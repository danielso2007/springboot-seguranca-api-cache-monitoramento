package br.com.forum.controller.dto;

import java.time.LocalDateTime;

import br.com.forum.entity.Resposta;

public class RespostaDto {

	private Long id;
	private String mensagem;
	private LocalDateTime dataCriacao;
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
