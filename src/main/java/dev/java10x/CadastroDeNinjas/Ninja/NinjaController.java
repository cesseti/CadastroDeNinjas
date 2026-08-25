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
    public String cadastrar() {
        return ("Ninja cadastrado!");
    }

    //Mostrar todos os ninjas (Read)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Mostrar ninja por id (Read)
    @GetMapping("/listar/{id}")
    public NinjaModel ninjaPorId(@PathVariable Long id) {
        return ninjaService.ninjaPorId(id);
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
