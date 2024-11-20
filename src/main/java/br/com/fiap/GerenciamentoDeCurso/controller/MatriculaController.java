package br.com.fiap.GerenciamentoDeCurso.controller;

import br.com.fiap.GerenciamentoDeCurso.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    // Listar todas as matrículas
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("matriculas", matriculaRepository.findAll());
        return "matricula/listar";
    }

    // Página de cadastro de matrícula
    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("matricula", new Matricula());
        return "matricula/cadastrar";
    }

    // Salvar nova matrícula
    @PostMapping("/salvar")
    public String salvar(@Valid Matricula matricula, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "matricula/cadastrar";
        }
        matriculaRepository.save(matricula);
        return "redirect:/matricula/listar";
    }

    // Editar matrícula
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Matricula matricula = matriculaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Matrícula inválida"));
        model.addAttribute("matricula", matricula);
        return "matricula/editar";
    }

    // Atualizar matrícula
    @PostMapping("/atualizar")
    public String atualizar(@Valid Matricula matricula, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "matricula/editar";
        }
        matriculaRepository.save(matricula);
        return "redirect:/matricula/listar";
    }

    // Excluir matrícula
    @PostMapping("/excluir")
    @Transactional
    public String excluir(@RequestParam("id") Long id, Model model) {
        matriculaRepository.deleteById(id);
        return "redirect:/matricula/listar";
    }
}
