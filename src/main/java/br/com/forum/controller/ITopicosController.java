package br.com.forum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.forum.controller.dto.TopicoDto;
import br.com.forum.controller.form.TopicoForm;

public interface ITopicosController {

	List<TopicoDto> list(String nomeCurso);
	ResponseEntity<DetalhesDoTopicoDto> findById(Long id);
	ResponseEntity<TopicoDto> save(@Valid TopicoForm form, UriComponentsBuilder uriBuilder);
	ResponseEntity<TopicoDto> update(Long id, @Valid TopicoForm form);
	ResponseEntity<?> delete(Long id);

}
