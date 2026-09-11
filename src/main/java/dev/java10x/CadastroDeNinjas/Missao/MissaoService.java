package dev.java10x.CadastroDeNinjas.Missao;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;
    private MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public MissaoDTO cadastrar (MissaoDTO missaoDTO) {
        MissaoModel missao = new MissaoMapper().map(missaoDTO);
        missao = missaoRepository.save(missao);
        return missaoMapper.map(missao);

    }

    public List<MissaoDTO> listar () {
        List<MissaoModel> missoes = missaoRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    public MissaoDTO buscar (Long id) {
        Optional <MissaoModel> missao = missaoRepository.findById(id);
        return missao.map(missaoMapper::map).orElse(null);
    }

    public MissaoDTO editar (Long id, MissaoDTO missaoDTO) {
        Optional<MissaoModel> missaoExistente = missaoRepository.findById(id);
        if(missaoExistente.isPresent()){
            MissaoModel missaoEditada = missaoMapper.map(missaoDTO);
            missaoEditada.setId(id);
            MissaoModel missaoSalva = missaoRepository.save(missaoEditada);
            return missaoMapper.map(missaoSalva);
        }
        return null;
    }

    public void deletar (Long id) {
        missaoRepository.deleteById(id);
    }
}
