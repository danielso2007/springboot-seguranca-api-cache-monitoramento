package br.com.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import br.com.forum.entity.Curso;
import br.com.forum.entity.Topico;
import br.com.forum.repository.CursoRepository;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representa um cadastro de um tópico.")
@JsonRootName(value = "TopicoForm")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Validated
public class TopicoForm extends BaseTopicoForm {

	@Schema(description = "O nome do cursos.", example = "Desenvolvimento")
	@NotNull(message = "O nome do curso não pode ser nulo")
	@NotEmpty(message = "O nome do curso não pode ser vazio")
	private String nomeCurso;

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(getTitulo(), getMensagem(), curso);
	}

}
