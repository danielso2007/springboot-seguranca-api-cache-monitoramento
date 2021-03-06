package br.com.forum.controller.impl;

import java.net.URI;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.forum.config.Constants;
import br.com.forum.controller.ITopicosController;
import br.com.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.forum.controller.dto.TopicoDto;
import br.com.forum.controller.form.TopicoForm;
import br.com.forum.entity.Topico;
import br.com.forum.service.ITopicosService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constants.TOPICOS)
public class TopicosController implements ITopicosController {

	private static final String CACHE_LIST_TOPICOS = "listaTopicos";
	private static final String CACHE_TOPICO = "topico";

	@Autowired
	private ITopicosService service;

	@Cacheable(value = CACHE_LIST_TOPICOS)
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	@Override
	public Page<TopicoDto> list(
			@RequestParam(required = false) String nomeCurso,
			@PageableDefault(page = Constants.DEFAULT_INT_PAGE, size = Constants.DEFAULT_INT_SIZE, sort = {
					Constants.DEFAULT_SORT_COLUMN }, direction = Direction.ASC) Pageable pageable) {
		if (nomeCurso == null) {
			return TopicoDto.converter(service.findAll(pageable));
		}
		return TopicoDto.converter(service.findByCursoNome(nomeCurso, pageable));
	}

	// TODO: Remover depois.
	@Deprecated
	@Override
	public Page<TopicoDto> list(@RequestParam(required = false) String nomeCurso,
			@RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
			@RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
			@RequestParam(required = false, defaultValue = Constants.EMPTY) String sort,
			@RequestParam(required = false, defaultValue = Constants.EMPTY) String direction) {
		if (nomeCurso == null) {
			return TopicoDto.converter(service.findAll(page, size, sort, direction));
		}
		return TopicoDto.converter(service.findByCursoNome(nomeCurso, page, size, sort, direction));
	}

	@Cacheable(value = CACHE_TOPICO)
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/{id}", produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	@Override
	public ResponseEntity<DetalhesDoTopicoDto> findById(
			@PathVariable Long id) {
		try {
			return ResponseEntity.ok(new DetalhesDoTopicoDto(service.findById(id)));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@CacheEvict(allEntries = true, value = { CACHE_LIST_TOPICOS, CACHE_TOPICO })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	@Override
	public ResponseEntity<TopicoDto> save(
			@RequestBody @Valid TopicoForm form,
			UriComponentsBuilder uriBuilder) {
		Topico entity = service.save(form);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(entity));
	}

	@CacheEvict(allEntries = true, value = { CACHE_LIST_TOPICOS, CACHE_TOPICO })
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value = "/{id}", produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	@Override
	public ResponseEntity<TopicoDto> update(
			@PathVariable Long id,
			@RequestBody @Valid TopicoForm form) {
		try {
			return ResponseEntity.ok(new TopicoDto(service.update(id, form)));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@CacheEvict(allEntries = true, value = { CACHE_LIST_TOPICOS, CACHE_TOPICO })
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/{id}", produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	@Override
	public ResponseEntity<?> delete(
			@PathVariable Long id) {
		try {
			service.delete(id);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
