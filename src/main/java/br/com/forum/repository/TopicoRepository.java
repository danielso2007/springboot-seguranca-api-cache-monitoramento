package br.com.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.forum.entity.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

	Page<Topico> findByCursoNome(String nomeCurso, Pageable pageable);
	Page<Topico> findByCursoNomeIgnoreCase(String nomeCurso, Pageable pageable);
	
}
