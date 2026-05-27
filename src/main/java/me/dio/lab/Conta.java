package me.dio.lab;

import lombok.Getter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> historico;
    protected List<Investimento> investimentos;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.historico = new ArrayList<>();
        this.investimentos = new ArrayList<>();
    }

    public List<Transacao> getHistorico() {
        return Collections.unmodifiableList(historico);
    }

    public abstract void imprimirExtrato();

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.nome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        if (!investimentos.isEmpty()) {
            System.out.println("--- Investimentos ---");
            investimentos.forEach(System.out::println);
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            adicionarTransacao(TipoTransacao.DEPOSITO, valor, "Depósito em conta");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            adicionarTransacao(TipoTransacao.SAQUE, valor, "Saque em conta");
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, Conta contaDestino) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            this.adicionarTransacao(TipoTransacao.TRANSFERENCIA_ENVIADA, valor, "Transferência para " + contaDestino.getCliente().nome());
            contaDestino.adicionarTransacao(TipoTransacao.TRANSFERENCIA_RECEBIDA, valor, "Transferência de " + this.getCliente().nome());
            return true;
        }
        return false;
    }

    public boolean transferirPix(double valor, Conta contaDestino) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            this.adicionarTransacao(TipoTransacao.TRANSFERENCIA_ENVIADA, valor, "PIX para " + contaDestino.getCliente().nome());
            contaDestino.adicionarTransacao(TipoTransacao.TRANSFERENCIA_RECEBIDA, valor, "PIX de " + this.getCliente().nome());
            return true;
        }
        return false;
    }

    public boolean criarInvestimento(String nome, double valor, double taxa) {
        if (this.sacar(valor)) {
            Investimento investimento = new Investimento(nome, valor, taxa);
            this.investimentos.add(investimento);
            this.adicionarTransacao(TipoTransacao.INVESTIMENTO, valor, "Investimento criado: " + nome);
            return true;
        }
        return false;
    }

    protected void adicionarTransacao(TipoTransacao tipo, double valor, String descricao) {
        this.historico.add(new Transacao(java.time.LocalDateTime.now(), tipo, valor, descricao));
    }
}
