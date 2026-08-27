package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public NinjaModel cadastrar(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel buscarPorId(Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaModel editar(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
}
