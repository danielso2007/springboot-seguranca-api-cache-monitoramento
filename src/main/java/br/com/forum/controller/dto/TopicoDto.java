package br.com.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import br.com.forum.entity.Topico;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representa a exibição de um tópico.")
@JsonRootName(value = "TopicoDto")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Validated
public class TopicoDto {

	@Schema(description = "O id do tópico.", example = "122")
	private Long id;
	@Schema(description = "O título do tópico.", example = "Dúvida 18")
	private String titulo;
	@Schema(description = "A mensagem do tópico.", example = "Sed ornare massa lacus, pretium faucibus...")
	private String mensagem;
	@Schema(description = "A data de criação do tópico.", example = "2020-05-29T23:39:13.186073")
	private LocalDateTime dataCriacao;

	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static List<TopicoDto> converter(List<Topico> topicos) {
		return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
	}

	public static Page<TopicoDto> converter(Page<Topico> topicos) {
		return topicos.map(TopicoDto::new);
	}

	public static Builder Builder() {
		return new Builder();
	}
	
	public static class Builder {

		private Long id;
		private String titulo;
		private String mensagem;
		private LocalDateTime dataCriacao;

		public Builder() {
		}

		public Builder id(Long value) {
			this.id = value;
			return this;
		}

		public Builder titulo(String value) {
			this.titulo = value;
			return this;
		}

		public Builder mensagem(String value) {
			this.mensagem = value;
			return this;
		}

		public Builder id(LocalDateTime value) {
			this.dataCriacao = value;
			return this;
		}
		
		public TopicoDto build() {
			return new TopicoDto(this);
		}

	}

	private TopicoDto(Builder builder) {
		id = builder.id;
		titulo = builder.titulo;
		mensagem = builder.mensagem;
		dataCriacao = builder.dataCriacao;
	}

}
