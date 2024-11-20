package br.com.fiap.GerenciamentoDeCurso.controller;

import br.com.fiap.GerenciamentoDeCurso.repository.CursoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/form-curso")
    public String cadastrar(Model model){
    model.addAttribute("curso", new Curso());
        return "curso/cadastro";
    }

    @PostMapping("/save")
    public String salvarCurso(@ModelAttribute Curso curso, Model model) {
        cursoRepository.save(curso);
        model.addAttribute("msg", "Curso salvo com sucesso!");
        return "redirect:/curso/lista";  // Redireciona para a mesma página ou para uma página de sucesso.
    }

    @GetMapping("/lista")
    public String listar(Model model){
        model.addAttribute("cursos", cursoRepository.findAll());
        return "curso/lista";
    }


    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("curso", cursoRepository.findById(id));
        return "curso/editar";
    }

    @PostMapping("/editar")
    @Transactional
    public String editar(@Valid Curso curso, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {




        cursoRepository.save(curso);


        redirectAttributes.addFlashAttribute("msg", "Curso atualizado com sucesso!");


        return "redirect:/curso/lista";  // Redireciona para a página de lista de cursos
    }



    @PostMapping("/excluir")
    @Transactional
    public String remover(@RequestParam Long idCurso, RedirectAttributes redirectAttributes) {
        cursoRepository.deleteById(idCurso);  // Usando cursoRepository para excluir o curso
        redirectAttributes.addFlashAttribute("msg", "Curso removido!");  // Mensagem de sucesso
        return "redirect:/curso/lista";  // Redireciona para a lista de cursos
    }








}
