package br.com.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonRootName(value = "BaseTopicoForm")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Validated
public abstract class BaseTopicoForm {

	@Schema(description = "O título do tópico.", example = "Dúvida 18", required = true)
	@NotNull(message = "O título não pode ser nulo")
	@NotEmpty(message = "O título não pode ser vazio")
	@Length(min = 5, message = "Título deve ter no mínimo 5 caracteres")
	private String titulo;

	@Schema(description = "A mensagem do tópico.", example = "Sed ornare massa lacus, pretium faucibus...", required = true)
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
