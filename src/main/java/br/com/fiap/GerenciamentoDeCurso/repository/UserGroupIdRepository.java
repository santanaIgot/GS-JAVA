package br.com.fiap.GerenciamentoDeCurso.repository;

import br.com.fiap.GerenciamentoDeCurso.model.Role;
import br.com.fiap.GerenciamentoDeCurso.model.UserGroupId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupIdRepository extends JpaRepository<UserGroupId, Long> {
    UserGroupId findByName(String name);
}
