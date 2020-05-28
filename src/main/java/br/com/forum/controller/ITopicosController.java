package br.com.forum.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.forum.controller.dto.TopicoDto;
import br.com.forum.controller.form.TopicoForm;

public interface ITopicosController {

	Page<TopicoDto> list(String nomeCurso, Pageable pageable);
	Page<TopicoDto> list(String nomeCurso, int page, int size, String sort, String direction);
	ResponseEntity<DetalhesDoTopicoDto> findById(Long id);
	ResponseEntity<TopicoDto> save(@Valid TopicoForm form, UriComponentsBuilder uriBuilder);
	ResponseEntity<TopicoDto> update(Long id, @Valid TopicoForm form);
	ResponseEntity<?> delete(Long id);

}
