package dev.java10x.CadastroDeNinjas.Ninja;

import dev.java10x.CadastroDeNinjas.Missao.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String rank;
    private int idade;
    private MissaoModel missao;
}
