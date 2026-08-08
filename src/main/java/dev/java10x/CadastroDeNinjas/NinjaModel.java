package dev.java10x.CadastroDeNinjas;


import jakarta.persistence.*;

//Entity transforma a classe em tabela e @Table só da o nome
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

//@Id usado com @GeneratedValue para dizer que o primeiro atributo abaixo é o id e vai ser incrementado do 1 em diante
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
