package Exer;

import java.io.Serializable;

public class Pretendente implements Serializable {
    private String nome;
    private int idade;
    private String pretencao;

    public Pretendente(String nome, int idade, String pretencao) {
        this.nome = nome;
        this.idade = idade;
        this.pretencao = pretencao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getPretencao() {
        return pretencao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Pretensão: " + pretencao;
    }
}
