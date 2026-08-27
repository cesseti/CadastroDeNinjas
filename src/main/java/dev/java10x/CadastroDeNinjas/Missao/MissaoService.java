package dev.java10x.CadastroDeNinjas.Missao;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public MissaoModel cadastrar (MissaoModel missao) {
        return missaoRepository.save(missao);
    }

    public List<MissaoModel> listar () {
        return missaoRepository.findAll();
    }

    public MissaoModel buscar (Long id) {
        Optional <MissaoModel> missao = missaoRepository.findById(id);
        return missao.orElse(null);
    }

    public MissaoModel editar (Long id, MissaoModel missaoEditada) {
        if (missaoRepository.existsById(id)) {
            return missaoRepository.save(missaoEditada);
        }
        return null;
    }

    public void deletar (Long id) {
        missaoRepository.deleteById(id);
    }
}
