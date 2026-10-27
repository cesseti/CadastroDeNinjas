package dev.java10x.CadastroDeNinjas.Missao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> cadastrar(@RequestBody MissaoDTO missao) {
        MissaoDTO novaMissao = missaoService.cadastrar(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão " + novaMissao.getNome() + " cadastrada com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissaoDTO>> listarMissoes() {
        List<MissaoDTO> missoes = missaoService.listar();

        return ResponseEntity.ok(missoes);
    }

    //Buscar missao especifica  (Read)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        MissaoDTO missao = missaoService.buscar(id);
        if (missao != null){
            return ResponseEntity.ok(missao);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão de ID " + id + " não encontrado, verifique o id e tente novamente");
        }
    }

    //Alterar missao (Update)
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody MissaoDTO missaoEditada) {
        MissaoDTO missao = missaoService.editar(id, missaoEditada);
        if (missao != null){
            return ResponseEntity.ok("Missão editada com sucessso: " + missao);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão de ID " + id + " não encontrado");
        }
    }

    //Deletar missao (Delete)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        if (missaoService.buscar(id) != null) {
            missaoService.deletar(id);
            return ResponseEntity.ok("Missão de id " + id + " deletada com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão de ID " + id + " não encontrado");
        }
    }
}
