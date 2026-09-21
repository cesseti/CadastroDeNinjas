package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasvindas(){
        return ("Bem vindo a minha primeira rota em Java com Spring!!");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.cadastrar(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja cadastrado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    //Mostrar todos os ninjas (Read)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();

        return ResponseEntity.ok(ninjas);
    }

    //Mostrar ninja por id (Read)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.buscarPorId(id);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de ID " + id + " não encontrado, verifique o id e tente novamente");
        }
    }

    //Alterar dados do Ninja por ID (Update)
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody NinjaDTO ninjaEditado ) {

        NinjaDTO ninja = ninjaService.editar(id, ninjaEditado);

        if(ninja != null){
            return ResponseEntity.ok("Ninja editado com sucesso " + ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de ID " + id + " não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {
        if (ninjaService.buscarPorId(id) != null){
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja de ID " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de ID " + id + "não encontrado");
        }
    }

}
