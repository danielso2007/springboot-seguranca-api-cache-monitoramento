package br.com.forum.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "O nome não pode ser nulo")
	@NotEmpty(message = "O nome não pode ser vazio")
	@Length(min = 5, message = "O nome deve ter no mínimo 5 caracteres")
	@Column(nullable = false)
	private String nome;
	@NotNull(message = "A mensagem não pode ser nulo")
	@NotEmpty(message = "A mensagem não pode ser vazio")
	@Column(nullable = false)
	@Email(message = "E-mail inválido")
	private String email;
	@NotNull(message = "A senha não pode ser nulo")
	@NotEmpty(message = "A senha não pode ser vazio")
	@Length(min = 3, message = "A senha deve ter no mínimo 5 caracteres")
	@Column(nullable = false)
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, nome, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha);
	}

	@Override
	public String toString() {
		return String.format("Usuario [id=%s, nome=%s, email=%s, senha=%s]", id, nome, email, senha);
	}

}
