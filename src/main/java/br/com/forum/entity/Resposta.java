package br.com.forum.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Resposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "A mensagem não pode ser nulo")
	@NotEmpty(message = "A mensagem não pode ser vazio")
	@Length(min = 5, message = "A mensagem deve ter no mínimo 5 caracteres")
	@Column(nullable = false, length = 500)
	private String mensagem;
	@ManyToOne(fetch = FetchType.LAZY)
	private Topico topico;
	@Column(nullable = false)
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario autor;
	@Column(nullable = false)
	private Boolean solucao = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Boolean getSolucao() {
		return solucao;
	}

	public void setSolucao(Boolean solucao) {
		this.solucao = solucao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataCriacao, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Resposta)) {
			return false;
		}
		Resposta other = (Resposta) obj;
		return Objects.equals(dataCriacao, other.dataCriacao) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return String.format("Resposta [id=%s, mensagem=%s, dataCriacao=%s, solucao=%s]", id, mensagem, dataCriacao,
				solucao);
	}

}
