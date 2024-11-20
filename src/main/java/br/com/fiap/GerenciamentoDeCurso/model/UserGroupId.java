package br.com.fiap.GerenciamentoDeCurso.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "UserGroupId")
@Getter
@Setter
public class UserGroupId {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    private List<String> users;
}