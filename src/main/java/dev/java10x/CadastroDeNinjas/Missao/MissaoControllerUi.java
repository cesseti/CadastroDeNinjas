package dev.java10x.CadastroDeNinjas.Missao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/missao/ui")
public class MissaoControllerUi {

    private final MissaoService missaoService;

    public MissaoControllerUi(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("/listar")
    public String listarMissoes(Model model) {
        List<MissaoDTO> missoes = missaoService.listar();
        model.addAttribute("missoes", missoes);
        return "listarMissoes";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMissao(@PathVariable Long id) {
        missaoService.deletar(id);
        return "redirect:/missao/ui/listar";
    }

    @GetMapping("/buscar/{id}")
    public String buscarPorId(@PathVariable Long id, Model model) {
        MissaoDTO missao = missaoService.buscar(id);
        if (missao != null){
            model.addAttribute("missao", missao);
            return "detalhesMissao";
        } else {
            model.addAttribute("mensagem", "Missão não encontrada");
            return "listarMissoes";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarMissao(Model model) {
        model.addAttribute("missao", new MissaoDTO());
        return "adicionarMissao";
    }

    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute MissaoDTO missao, RedirectAttributes redirectAttributes) {
        missaoService.cadastrar(missao);
        redirectAttributes.addFlashAttribute("mensagem", "Missão cadastrada com sucesso!");
        return "redirect:/missao/ui/listar";
    }
}
