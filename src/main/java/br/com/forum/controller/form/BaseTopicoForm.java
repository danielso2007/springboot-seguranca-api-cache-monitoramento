package br.com.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public abstract class BaseTopicoForm {

	@NotNull(message = "O título não pode ser nulo")
	@NotEmpty(message = "O título não pode ser vazio")
	@Length(min = 5, message = "Título deve ter no mínimo 5 caracteres")
	private String titulo;

	@NotNull(message = "A mensagem não pode ser nulo")
	@NotEmpty(message = "A mensagem não pode ser vazio")
	@Length(min = 10, message = "Mensagem deve ter no mínimo 10 caracteres")
	private String mensagem;

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

}
