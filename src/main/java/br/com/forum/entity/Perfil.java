package br.com.forum.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import br.com.forum.enumerator.Roles;

@Entity
@JsonRootName(value = "perfil")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Validated
public class Perfil implements GrantedAuthority {

	private static final long serialVersionUID = -1391340976804069523L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "O nome não pode ser nulo")
	@NotEmpty(message = "O nome não pode ser vazio")
	@Length(min = 5, message = "O nome deve ter no mínimo 5 caracteres")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Roles nome;

	@Override
	public String getAuthority() {
		return nome.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Roles getNome() {
		return nome;
	}

	public void setNome(Roles nome) {
		this.nome = nome;
	}
	
	public String getRole() {
		return nome.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Perfil)) {
			return false;
		}
		Perfil other = (Perfil) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return String.format("Perfil [id=%s, nome=%s]", id, nome);
	}

}
