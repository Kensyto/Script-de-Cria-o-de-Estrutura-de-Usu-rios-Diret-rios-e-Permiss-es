package me.dio.lab;

import java.time.LocalDateTime;

public record Transacao(LocalDateTime data, TipoTransacao tipo, double valor, String descricao) {
}
