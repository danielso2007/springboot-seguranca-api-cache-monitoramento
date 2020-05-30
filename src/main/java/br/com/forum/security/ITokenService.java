package br.com.forum.security;

import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public interface ITokenService {

	/**
	 * Recuperar nome de usuário do token jwt.
	 */
	String getUsernameFromToken(String token);

	/**
	 * recuperar data de validade do token jwt.
	 * @param token
	 * @return
	 */
	Date getExpirationDateFromToken(String token);

	<T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);

	/**
	 * Gerar token para o usuário.
	 * @param userDetails
	 * @return
	 */
	String generateToken(UserDetails userDetails);

	/**
	 * Validar token.
	 * @param token
	 * @param userDetails
	 * @return
	 */
	Boolean validateToken(String token, UserDetails userDetails);

}
