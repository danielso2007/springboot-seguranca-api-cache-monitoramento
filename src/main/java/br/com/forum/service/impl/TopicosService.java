package br.com.forum.service.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.forum.config.Constants;
import br.com.forum.controller.form.TopicoForm;
import br.com.forum.entity.Topico;
import br.com.forum.repository.CursoRepository;
import br.com.forum.repository.TopicoRepository;
import br.com.forum.service.ITopicosService;

@Service
@Transactional(readOnly = true)
public class TopicosService implements ITopicosService {

	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	private Pageable createPageable(int page, int size, String sort, String direction) {
		Direction direct = Direction.ASC;
		Sort sortBy = Sort.by(direct, Constants.DEFAULT_SORT_COLUMN);
		
		if (direction != null && direction.equalsIgnoreCase("desc")) {
			direct = Direction.DESC;
		}
		
		if (sort != null && !sort.isEmpty()) {
			sortBy = Sort.by(direct, sort);
		}
		
		return PageRequest.of(page, size, sortBy);
	}
	
	@Override
	public Page<Topico> findAll(Pageable pageable) {
		return topicoRepository.findAll(pageable);
	}

	@Override
	public Page<Topico> findByCursoNome(String nomeCurso, Pageable pageable) {
		return topicoRepository.findByCursoNomeIgnoreCase(nomeCurso, pageable);
	}
	
	@Override
	public Page<Topico> findAll(int page, int size, String sort, String direction) {
		return topicoRepository.findAll(createPageable(page, size, sort, direction));
	}

	@Override
	public Page<Topico> findByCursoNome(String nomeCurso, int page, int size, String sort, String direction) {
		return topicoRepository.findByCursoNomeIgnoreCase(nomeCurso, createPageable(page, size, sort, direction));
	}

	@Override
	public Topico findById(Long id) throws EntityNotFoundException {
		Optional<Topico> entity = topicoRepository.findById(id);
		if (entity.isPresent()) {
			return entity.get();
		}
		throw new EntityNotFoundException();
	}

	@Override
	public Topico save(TopicoForm form) {
		return save(form.converter(cursoRepository));
	}

	@Transactional
	@Override
	public Topico save(Topico entity) {
		return topicoRepository.save(entity);
	}

	@Override
	public Topico update(Long id, TopicoForm form) {
		return update(id, form.converter(cursoRepository));
	}

	@Transactional
	@Override
	public Topico update(Long id, Topico entity) {
		Topico original = findById(id);
		original.setTitulo(entity.getTitulo());
		original.setMensagem(entity.getMensagem());
		return topicoRepository.save(original);
	}

	@Transactional
	@Override
	public void delete(Long id) throws EntityNotFoundException {
		Optional<Topico> optional = topicoRepository.findById(id);
		if (optional.isPresent()) {
			topicoRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException();
		}
	}

}
