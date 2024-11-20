package br.com.fiap.GerenciamentoDeCurso.controller;

import br.com.fiap.GerenciamentoDeCurso.dto.UserForm;
import br.com.fiap.GerenciamentoDeCurso.repository.RoleRepository;
import br.com.fiap.GerenciamentoDeCurso.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService userService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        model.addAttribute("roles", roleRepository.findAll());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userForm") UserForm userForm) {
        userService.saveUser(userForm.getUsername(),
                passwordEncoder.encode(userForm.getPassword()), userForm.getRoles());
        return "redirect:/login";
    }

    @Controller
    public class LoginController {
        @GetMapping("/login")
        public String login() {
            return "usuario/login";
        }
    }

}