package com.springboot.crudspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.springboot.crudspring.model.Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.springboot.crudspring.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping(path = "/pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping({"/","index"})
    public String home() {
        return "index";
    }


    @GetMapping("/cadastrar")
    public String cadastrarPessoa(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "cadastrarPessoa";

    }

    @PostMapping(path = "/save")
    public String salvarPessoa(@ModelAttribute Pessoa pessoa, Model model) {
        pessoaRepository.save(pessoa);
        List<Pessoa> listaPessoa = (List<Pessoa>) pessoaRepository.findAll();
        model.addAttribute("pessoas", listaPessoa);
        return "listarPessoas";
    }

    @GetMapping("/listar")
        public String listasPessoas(Model model) {
        List<Pessoa> listaPessoa = (List<Pessoa>) pessoaRepository.findAll();
        model.addAttribute("pessoas", listaPessoa);
        return "listarPessoas";

    }

    @GetMapping("/alterar/{id}")
        public String alterarPesoa(@PathVariable Integer id, Model model) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        model.addAttribute("pessoa", pessoa);
        return "alterarPessoa";
    }

    @PostMapping("/alterar")
    public String alterarPessoa(@ModelAttribute Pessoa novaPessoa, Model model) {
        pessoaRepository.save(novaPessoa);
        List<Pessoa> listaPessoa = (List<Pessoa>) pessoaRepository.findAll();
        model.addAttribute("pessoas", listaPessoa);
        return "listarPessoas";
    }

    @GetMapping("excluir/{id}")
    public String excluirPessoa(@PathVariable Integer id, Model model) {
        pessoaRepository.deleteById(id);
        List<Pessoa> listaPessoa = (List<Pessoa>) pessoaRepository.findAll();
        model.addAttribute("pessoas", listaPessoa);
        return "listarPessoas";

    }

    }





