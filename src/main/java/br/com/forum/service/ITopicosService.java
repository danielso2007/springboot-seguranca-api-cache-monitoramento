package br.com.forum.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.forum.controller.form.TopicoForm;
import br.com.forum.entity.Topico;

public interface ITopicosService {

	Page<Topico> findAll(Pageable pageable);
	Page<Topico> findByCursoNome(String nomeCurso, Pageable pageable);
	Page<Topico> findAll(int page, int size, String order, String direction);
	Page<Topico> findByCursoNome(String nomeCurso, int page, int size, String order, String direction);
	Topico findById(Long id) throws EntityNotFoundException;
	Topico save(TopicoForm form);
	Topico save(Topico entity);
	Topico update(Long id, TopicoForm form);
	Topico update(Long id, Topico entity);
	void delete(Long id);
	
}
