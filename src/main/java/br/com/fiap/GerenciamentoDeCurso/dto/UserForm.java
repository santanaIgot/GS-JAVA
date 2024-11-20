package br.com.fiap.GerenciamentoDeCurso.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserForm {
    private Long id;
    private String name;
    private List<String> users; // Lista de roles selecionadas pelo administrador
}
