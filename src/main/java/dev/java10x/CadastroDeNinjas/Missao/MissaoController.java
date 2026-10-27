package dev.java10x.CadastroDeNinjas.Missao;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasvindas(){
        return ("Bem vindo a pag de missoes");
    }

    //Adicionar missao (Create)
    @PostMapping("/cadastrar")
    @Operation(summary = "Cria uma novas missao", description = "Rota cria uma nova missao e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missao criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criaçao da missao")
    })
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

    @GetMapping("/buscar/{id}")
    @Operation(summary = "Busca o ninja por Id", description = "Rota busca um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missao nao encontrada")
    })
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        MissaoDTO missao = missaoService.buscar(id);
        if (missao != null){
            return ResponseEntity.ok(missao);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão de ID " + id + " não encontrado, verifique o id e tente novamente");
        }
    }

    @PutMapping("/editar/{id}")
    @Operation(summary = "Edita a missao por Id", description = "Rota edita uma missao pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao editada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missao nao encontrada, nao foi possivel editar")
    })
    public ResponseEntity<?> editar(
            @Parameter(description = "Usuario manda o id no caminho da requisiçao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados da missao a ser editada no corpo da requisiçao")
            @RequestBody MissaoDTO missaoEditada) {
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
