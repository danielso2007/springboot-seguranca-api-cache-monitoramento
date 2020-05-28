package br.com.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.forum.entity.Curso;
import br.com.forum.entity.Topico;
import br.com.forum.repository.CursoRepository;

public class TopicoForm extends BaseTopicoForm {

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
