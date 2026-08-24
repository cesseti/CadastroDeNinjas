package dev.java10x.CadastroDeNinjas.Missao;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/missao")
public class MissaoController {
    @GetMapping("/boasvindas")
    public String boasvindas(){
        return ("Bem vindo a pag de missoes");
    }

    //Adicionar missao (Create)
    @PostMapping("/cadastrar")
    public String cadastrar() {
        return ("Misao cadastrada!");
    }

    //Mostrar todos as missoes (Read)
    @GetMapping("/listar")
    public String listarMissoes() {
        return ("Esses são todas as missoes!");
    }


    //Alterar missao (Update)
    @PutMapping("/editarnmissao")
    public String editarMissao() {
        return ("missao editada!");
    }

    //Deletar missao (Delete)
    @DeleteMapping("/deletarmissao")
    public String deletarMisao() {
        return ("Missao deletada!");
    }


}
