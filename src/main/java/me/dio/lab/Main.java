package me.dio.lab;

import me.dio.lab.forca.JogoForca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- DIO Labs ---");
            System.out.println("1. Jogar Forca");
            System.out.println("2. Sistema Bancário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> JogoForca.iniciar();
                case 2 -> BancoApp.iniciar();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
