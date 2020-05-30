package br.com.forum.security;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import br.com.forum.security.model.JwtRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Auth", description = "Authentication API")
public interface IAuthenticationController {

	@Operation(summary = "Responsável pela autenticação.", description = "Responsável pela autenticação.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Quando retornado um token com sucesso."),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado."),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	ResponseEntity<?> authenticate(@Valid JwtRequest authenticationRequest);

}
