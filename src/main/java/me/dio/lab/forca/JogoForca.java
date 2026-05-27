package me.dio.lab.forca;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoForca {
    private static final List<PalavraData> BANCO_PALAVRAS = List.of(
        new PalavraData("JAVA", Categoria.OBJETO),
        new PalavraData("ELEFANTE", Categoria.ANIMAL),
        new PalavraData("BANANA", Categoria.FRUTA),
        new PalavraData("BRASIL", Categoria.PAIS),
        new PalavraData("PROGRAMADOR", Categoria.OBJETO),
        new PalavraData("GIRAFA", Categoria.ANIMAL),
        new PalavraData("MELANCIA", Categoria.FRUTA),
        new PalavraData("PORTUGAL", Categoria.PAIS)
    );

    private record PalavraData(String palavra, Categoria categoria) {}

    public static void iniciar() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            PalavraData data = BANCO_PALAVRAS.get(random.nextInt(BANCO_PALAVRAS.size()));
            Partida partida = new Partida(data.palavra, data.categoria);

            System.out.println("\n=== JOGO DA FORCA ===");
            System.out.println("Categoria: " + partida.getCategoria());

            while (!partida.isVitoria() && !partida.isDerrota()) {
                Gallows.exibir(6 - partida.getTentativasRestantes());
                System.out.println("Palavra: " + partida.getPalavraMascarada());
                System.out.println("Letras erradas: " + partida.getLetrasErradas());
                System.out.println("Tentativas restantes: " + partida.getTentativasRestantes());
                System.out.print("Digite uma letra: ");

                String input = scanner.next();
                if (input.isEmpty()) continue;

                try {
                    boolean acertou = partida.adivinhar(input.charAt(0));
                    if (acertou) System.out.println("Boa! Você acertou uma letra.");
                    else System.out.println("Pena! A letra não existe na palavra.");
                } catch (ForcaException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            if (partida.isVitoria()) {
                System.out.println("\nPARABÉNS! Você venceu!");
                System.out.println("A palavra era: " + partida.getPalavraSecreta());
            } else {
                Gallows.exibir(6);
                System.out.println("\nGAME OVER! Você perdeu.");
                System.out.println("A palavra era: " + partida.getPalavraSecreta());
            }

            System.out.print("\nDeseja jogar novamente? (S/N): ");
            if (!scanner.next().equalsIgnoreCase("S")) break;
        }
        System.out.println("Obrigado por jogar!");
    }
}
