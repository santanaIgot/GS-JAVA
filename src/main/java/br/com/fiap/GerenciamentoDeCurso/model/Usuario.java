package br.com.fiap.GerenciamentoDeCurso.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter@Setter
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    private String cpf;

    private String name;

    private UserAdressId userAdressId;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<UserGroupId> users ;

    public Usuario(String username, String password, Set<UserGroupId> users) {
        this.username = username;
        this.password = password;
        this.users = users;
    }


}