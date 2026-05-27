package me.dio.lab;

import java.util.Scanner;

public class BancoApp {
    private static final Banco banco = new Banco("DIO Bank");
    private static final Scanner scanner = new Scanner(System.in);

    public static void iniciar() {
        scanner.useDelimiter("\n");
        int opcao = -1;

        while (opcao != 0) {
            exibirMenuPrincipal();
            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> criarConta();
                case 2 -> acessarConta();
                case 3 -> listarContas();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- DIO Bank - Menu Principal ---");
        System.out.println("1. Criar Conta");
        System.out.println("2. Acessar Conta (por número)");
        System.out.println("3. Listar Todas as Contas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarConta() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.next();
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.next();
        Cliente cliente = new Cliente(nome, cpf);

        System.out.println("Tipo de Conta: 1. Corrente | 2. Poupança");
        int tipo = lerInteiro();

        Conta conta = (tipo == 1) ? new ContaCorrente(cliente) : new ContaPoupanca(cliente);
        banco.adicionarConta(conta);

        System.out.println("Conta criada com sucesso! Número: " + conta.getNumero());
    }

    private static void acessarConta() {
        System.out.print("Digite o número da conta: ");
        int numero = lerInteiro();
        banco.buscarContaPorNumero(numero).ifPresentOrElse(
                BancoApp::menuConta,
                () -> System.out.println("Conta não encontrada.")
        );
    }

    private static void menuConta(Conta conta) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- Conta " + conta.getNumero() + " (" + conta.getCliente().nome() + ") ---");
            System.out.println("1. Depósito");
            System.out.println("2. Saque");
            System.out.println("3. Transferência");
            System.out.println("4. PIX");
            System.out.println("5. Criar Investimento");
            System.out.println("6. Ver Extrato");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Valor do depósito: ");
                    conta.depositar(lerDouble());
                }
                case 2 -> {
                    System.out.print("Valor do saque: ");
                    if (!conta.sacar(lerDouble())) System.out.println("Saldo insuficiente ou valor inválido.");
                }
                case 3 -> realizarTransferencia(conta, false);
                case 4 -> realizarTransferencia(conta, true);
                case 5 -> {
                    System.out.print("Nome do investimento: ");
                    String nome = scanner.next();
                    System.out.print("Valor: ");
                    double valor = lerDouble();
                    System.out.print("Taxa (ex: 0.05 para 5%): ");
                    double taxa = lerDouble();
                    if (!conta.criarInvestimento(nome, valor, taxa)) System.out.println("Saldo insuficiente.");
                }
                case 6 -> conta.imprimirExtrato();
                case 0 -> {}
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void realizarTransferencia(Conta origem, boolean isPix) {
        System.out.print("Número da conta destino: ");
        int destinoNum = lerInteiro();
        banco.buscarContaPorNumero(destinoNum).ifPresentOrElse(
                destino -> {
                    System.out.print("Valor: ");
                    double valor = lerDouble();
                    boolean sucesso = isPix ? origem.transferirPix(valor, destino) : origem.transferir(valor, destino);
                    if (sucesso) System.out.println("Operação realizada com sucesso!");
                    else System.out.println("Falha na operação (saldo insuficiente).");
                },
                () -> System.out.println("Conta destino não encontrada.")
        );
    }

    private static void listarContas() {
        if (banco.getContas().isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            banco.getContas().forEach(c ->
                System.out.println("Número: " + c.getNumero() + " | Titular: " + c.getCliente().nome() + " | Saldo: " + c.getSaldo())
            );
        }
    }

    private static int lerInteiro() {
        try {
            return Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static double lerDouble() {
        try {
            return Double.parseDouble(scanner.next());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
