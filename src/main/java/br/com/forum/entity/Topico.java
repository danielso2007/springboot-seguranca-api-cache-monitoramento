package br.com.forum.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.forum.enumerator.StatusTopico;

@Entity
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "O título não pode ser nulo")
	@NotEmpty(message = "O título não pode ser vazio")
	@Length(min = 5, message = "O título deve ter no mínimo 5 caracteres")
	@Column(nullable = false)
	private String titulo;
	@NotNull(message = "A mensagem não pode ser nulo")
	@NotEmpty(message = "A mensagem não pode ser vazio")
	@Length(min = 5, message = "A mensagem deve ter no mínimo 5 caracteres")
	@Column(nullable = false, length = 500)
	private String mensagem;
	@Column(nullable = false)
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario autor;
	@ManyToOne(fetch = FetchType.LAZY)
	private Curso curso;
	@OneToMany(mappedBy = "topico")
	private List<Resposta> respostas = new ArrayList<>();

	public Topico() {
	}

	public Topico(String titulo, String mensagem, Curso curso) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public void setStatus(StatusTopico status) {
		this.status = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataCriacao, id, mensagem, status, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Topico)) {
			return false;
		}
		Topico other = (Topico) obj;
		return Objects.equals(dataCriacao, other.dataCriacao) && Objects.equals(id, other.id)
				&& Objects.equals(mensagem, other.mensagem) && status == other.status
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return String.format("Topico [id=%s, titulo=%s, mensagem=%s, dataCriacao=%s, status=%s]", id, titulo, mensagem,
				dataCriacao, status);
	}

}
