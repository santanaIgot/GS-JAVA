package br.com.fiap.GerenciamentoDeCurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Optional<Curso> findById(Long id );
}
