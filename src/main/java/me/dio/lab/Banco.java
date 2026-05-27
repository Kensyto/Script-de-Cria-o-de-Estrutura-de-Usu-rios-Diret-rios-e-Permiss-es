package me.dio.lab;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public Optional<Conta> buscarContaPorNumero(int numero) {
        return contas.stream()
                .filter(c -> c.getNumero() == numero)
                .findFirst();
    }

    public List<Conta> buscarContasPorCpf(String cpf) {
        return contas.stream()
                .filter(c -> c.getCliente().cpf().equals(cpf))
                .toList();
    }
}
