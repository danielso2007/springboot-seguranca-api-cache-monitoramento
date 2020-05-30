package br.com.forum.security.model;

import java.io.Serializable;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representa a resposta de autenticação com um token válido.")
@JsonRootName(value = "JwtResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Validated
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -1372002744016909807L;

	@Schema(description = "O token de autenticação", example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ...")
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
