package dev.java10x.CadastroDeNinjas.Ninja;


import dev.java10x.CadastroDeNinjas.Missao.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Entity transforma a classe em tabela e @Table só da o nome
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

//@Id usado com @GeneratedValue para dizer que o primeiro atributo abaixo é o id e vai ser incrementado do 1 em diante
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissaoModel missao;

}
