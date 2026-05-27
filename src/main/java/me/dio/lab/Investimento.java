package me.dio.lab;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Investimento {
    private String nome;
    private double valor;
    private double taxaRendimento;

    @Override
    public String toString() {
        return String.format("Investimento: %s | Valor: %.2f | Taxa: %.2f%%", nome, valor, taxaRendimento * 100);
    }
}
