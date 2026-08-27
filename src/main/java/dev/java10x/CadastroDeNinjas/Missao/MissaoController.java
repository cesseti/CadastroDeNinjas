package dev.java10x.CadastroDeNinjas.Missao;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/missao")
public class MissaoController {

    MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("/boasvindas")
    public String boasvindas(){
        return ("Bem vindo a pag de missoes");
    }

    //Adicionar missao (Create)
    @PostMapping("/cadastrar")
    public MissaoModel cadastrar(@RequestBody MissaoModel missao) {
        return missaoService.cadastrar(missao);
    }

    //Mostrar todos as missoes (Read)
    @GetMapping("/listar")
    public List<MissaoModel> listarMissoes() {
        return missaoService.listar();
    }

    //Buscar missao especifica  (Read)
    @GetMapping("/buscar/{id}")
    public MissaoModel buscar(@PathVariable Long id) {
        return missaoService.buscar(id);
    }

    //Alterar missao (Update)
    @PutMapping("/editar/{id}")
    public MissaoModel editar(@PathVariable Long id, @RequestBody MissaoModel missao) {
        return missaoService.editar(id, missao);
    }

    //Deletar missao (Delete)
    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        missaoService.deletar(id);
    }


}
