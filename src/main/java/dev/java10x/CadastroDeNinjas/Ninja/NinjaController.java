package dev.java10x.CadastroDeNinjas.Ninja;

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

    //Adicionar ninja (Create)
    @PostMapping("/cadastrar")
    public NinjaDTO cadastrar(@RequestBody NinjaDTO ninja) {
        return ninjaService.cadastrar(ninja);
    }

    //Mostrar todos os ninjas (Read)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Mostrar ninja por id (Read)
    @GetMapping("/buscar/{id}")
    public NinjaModel buscarPorId(@PathVariable Long id) {
        return ninjaService.buscarPorId(id);
    }

    //Alterar dados do Ninja por ID (Update)
    @PutMapping("/editar/{id}")
    public NinjaModel editar(@PathVariable Long id, @RequestBody NinjaModel ninjaEditado ) {
        return ninjaService.editar(id, ninjaEditado);
    }

    //Deletar ninja por ID (Delete)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
    }

}
