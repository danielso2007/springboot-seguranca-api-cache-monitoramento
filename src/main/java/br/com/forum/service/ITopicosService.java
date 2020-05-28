package br.com.forum.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import br.com.forum.controller.form.TopicoForm;
import br.com.forum.entity.Topico;

public interface ITopicosService {

	List<Topico> findAll();
	List<Topico> findByCursoNome(String nomeCurso);
	Topico findById(Long id) throws EntityNotFoundException;
	Topico save(TopicoForm form);
	Topico save(Topico entity);
	Topico update(Long id, TopicoForm form);
	Topico update(Long id, Topico entity);
	void delete(Long id);
	
}
