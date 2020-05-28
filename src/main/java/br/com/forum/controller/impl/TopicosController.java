package br.com.forum.controller.impl;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping(Constants.ROOT_URL + Constants.V1 + "/topicos")
public class TopicosController implements ITopicosController {

	@Autowired
	private ITopicosService service;

	@GetMapping
	@Override
	public List<TopicoDto> list(String nomeCurso) {
		if (nomeCurso == null) {
			return TopicoDto.converter(service.findAll());
		}
		return TopicoDto.converter(service.findByCursoNome(nomeCurso));
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<DetalhesDoTopicoDto> findById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(new DetalhesDoTopicoDto(service.findById(id)));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@Override
	public ResponseEntity<TopicoDto> save(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico entity = service.save(form);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(entity));
	}

	@PutMapping("/{id}")
	@Override
	public ResponseEntity<TopicoDto> update(@PathVariable Long id, @RequestBody @Valid TopicoForm form) {
		try {
			return ResponseEntity.ok(new TopicoDto(service.update(id, form)));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			service.delete(id);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
