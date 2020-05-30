package br.com.forum.controller.dto;

import java.time.LocalDateTime;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import br.com.forum.entity.Resposta;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representa as respostas de um tópico.")
@JsonRootName(value = "RespostaDto")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Validated
public class RespostaDto {

	@Schema(description = "O id do tópico.", example = "122")
	private Long id;
	@Schema(description = "A mensagem do tópico.", example = "Sed ornare massa lacus, pretium faucibus...")
	private String mensagem;
	@Schema(description = "A data de criação do tópico.", example = "2020-05-29T23:39:13.186073")
	private LocalDateTime dataCriacao;
	@Schema(description = "O nome do criador do tópico.")
	private String nomeAutor;
	
	public RespostaDto(Resposta resposta) {
		this.id = resposta.getId();
		this.mensagem = resposta.getMensagem();
		this.dataCriacao = resposta.getDataCriacao();
		this.nomeAutor = resposta.getAutor().getNome();
	}

	public Long getId() {
		return id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}
	
	public static Builder Builder() {
		return new Builder();
	}
	
	public static class Builder {

		private Long id;
		private String nomeAutor;
		private String mensagem;
		private LocalDateTime dataCriacao;

		public Builder() {
		}

		public Builder id(Long value) {
			this.id = value;
			return this;
		}

		public Builder nomeAutor(String value) {
			this.nomeAutor = value;
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
		
		public RespostaDto build() {
			return new RespostaDto(this);
		}

	}

	private RespostaDto(Builder builder) {
		id = builder.id;
		nomeAutor = builder.nomeAutor;
		mensagem = builder.mensagem;
		dataCriacao = builder.dataCriacao;
	}
	
}
