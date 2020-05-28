package br.com.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.forum.entity.Topico;
import br.com.forum.enumerator.StatusTopico;

public class DetalhesDoTopicoDto {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	private StatusTopico status;
	private List<RespostaDto> respostas;

	public DetalhesDoTopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.nomeAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();
		this.respostas = new ArrayList<>();
		this.respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
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

	public String getNomeAutor() {
		return nomeAutor;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public List<RespostaDto> getRespostas() {
		return respostas;
	}

	public static Builder Builder() {
		return new Builder();
	}

	public static class Builder {

		private Long id;
		private String titulo;
		private String mensagem;
		private LocalDateTime dataCriacao;
		private String nomeAutor;
		private StatusTopico status;
		private List<RespostaDto> respostas;

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

		public Builder nomeAutor(String value) {
			this.nomeAutor = value;
			return this;
		}

		public Builder status(StatusTopico value) {
			this.status = value;
			return this;
		}

		public Builder respostas(List<RespostaDto> value) {
			this.respostas = value;
			return this;
		}

		public DetalhesDoTopicoDto build() {
			return new DetalhesDoTopicoDto(this);
		}

	}

	private DetalhesDoTopicoDto(Builder builder) {
		id = builder.id;
		titulo = builder.titulo;
		mensagem = builder.mensagem;
		dataCriacao = builder.dataCriacao;
		nomeAutor = builder.nomeAutor;
		status = builder.status;
		respostas = builder.respostas;
	}

}
