package br.com.forum.security.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 1950328402724300308L;

	@NotNull(message = "O username não pode ser nulo")
	@NotEmpty(message = "O username não pode ser vazio")
	private String username;
	@NotNull(message = "A senha não pode ser nulo")
	@NotEmpty(message = "A senha não pode ser vazio")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("LoginForm [username=%s, password=%s]", username, password);
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(username, password);
	}

}
