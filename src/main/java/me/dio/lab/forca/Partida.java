package me.dio.lab.forca;

import lombok.Getter;
import java.util.HashSet;
import java.util.Set;

@Getter
public class Partida {
    private final String palavraSecreta;
    private final Categoria categoria;
    private final Set<Character> letrasAdivinhadas;
    private final Set<Character> letrasErradas;
    private int tentativasRestantes;
    private static final int MAX_TENTATIVAS = 6;

    public Partida(String palavraSecreta, Categoria categoria) {
        this.palavraSecreta = palavraSecreta.toUpperCase();
        this.categoria = categoria;
        this.letrasAdivinhadas = new HashSet<>();
        this.letrasErradas = new HashSet<>();
        this.tentativasRestantes = MAX_TENTATIVAS;
    }

    public boolean adivinhar(char letra) {
        letra = Character.toUpperCase(letra);
        if (!Character.isLetter(letra)) {
            throw new ForcaException("Apenas letras são permitidas!");
        }
        if (letrasAdivinhadas.contains(letra) || letrasErradas.contains(letra)) {
            throw new ForcaException("Você já tentou esta letra!");
        }

        if (palavraSecreta.indexOf(letra) >= 0) {
            letrasAdivinhadas.add(letra);
            return true;
        } else {
            letrasErradas.add(letra);
            tentativasRestantes--;
            return false;
        }
    }

    public boolean isVitoria() {
        for (char c : palavraSecreta.toCharArray()) {
            if (Character.isLetter(c) && !letrasAdivinhadas.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isDerrota() {
        return tentativasRestantes <= 0;
    }

    public String getPalavraMascarada() {
        StringBuilder sb = new StringBuilder();
        for (char c : palavraSecreta.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(letrasAdivinhadas.contains(c) ? c : '_').append(' ');
            } else {
                sb.append(c).append(' ');
            }
        }
        return sb.toString().trim();
    }
}
