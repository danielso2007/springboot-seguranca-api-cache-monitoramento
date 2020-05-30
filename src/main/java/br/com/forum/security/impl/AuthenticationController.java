package br.com.forum.security.impl;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.forum.config.Constants;
import br.com.forum.security.IAuthenticationController;
import br.com.forum.security.ITokenService;
import br.com.forum.security.model.JwtRequest;
import br.com.forum.security.model.JwtResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constants.AUTH)
public class AuthenticationController implements IAuthenticationController {

	Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private ITokenService tokenService;

	@PostMapping
	@Override
	public ResponseEntity<?> authenticate(@RequestBody @Valid JwtRequest authenticationRequest) {
		try {
			String token = tokenService.generateToken((UserDetails) authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword()).getPrincipal());
			return ResponseEntity.ok(new JwtResponse(token));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	private Authentication authenticate(String username, String password) throws Exception {
		try {
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
