package br.com.fiap.GerenciamentoDeCurso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UserAdress")
@Setter@Getter
@NoArgsConstructor
public class UserAdressId {
    @Id
    @GeneratedValue
    private Long id;

    private String logradouro;

    private String numero;

    private String bairro;

    private String cep;

    private String zona;
}
