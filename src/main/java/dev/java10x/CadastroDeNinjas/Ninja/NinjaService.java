package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public NinjaDTO cadastrar(NinjaDTO ninjaDTO) {
        NinjaModel ninja = new NinjaMapper().map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel buscarPorId(Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaModel editar(Long id, NinjaModel ninjaEditado) {
        if (ninjaRepository.existsById(id)) {
            return ninjaRepository.save(ninjaEditado);
        }
        return null;
    }

    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
}
