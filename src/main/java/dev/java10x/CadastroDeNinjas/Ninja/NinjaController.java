package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasvindas(){
        return ("Bem vindo a minha primeira rota em Java com Spring!!");
    }

    //Adicionar ninja (Create)
    @PostMapping("/cadastrar")
    public String cadastrar() {
        return ("Ninja cadastrado!");
    }

    //Mostrar todos os ninjas (Read)
    @GetMapping("/todos")
    public String todos() {
        return ("Esses são todos os ninjas!");
    }

    //Mostrar ninja por id (Read)
    @GetMapping("/ninjaporid")
    public String ninjaPorId() {
        return ("Esse é o ninja que vc procura!");
    }

    //Alterar dados do Ninja por ID (Update)
    @PutMapping("/editarninja")
    public String editarNinjaPorId() {
        return ("Ninja editado!");
    }

    //Deletar ninja por ID (Delete)
    @DeleteMapping("/deletarninja")
    public String deletarNinja() {
        return ("Ninja deletado!");
    }

}
