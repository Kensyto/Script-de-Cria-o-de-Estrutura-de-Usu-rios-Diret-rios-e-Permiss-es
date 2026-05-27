package me.dio.lab.forca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {

    @Test
    void deveAdivinharLetraCorreta() {
        Partida partida = new Partida("JAVA", Categoria.OBJETO);
        assertTrue(partida.adivinhar('J'));
        assertTrue(partida.getLetrasAdivinhadas().contains('J'));
    }

    @Test
    void deveRegistrarLetraErrada() {
        Partida partida = new Partida("JAVA", Categoria.OBJETO);
        assertFalse(partida.adivinhar('X'));
        assertTrue(partida.getLetrasErradas().contains('X'));
        assertEquals(5, partida.getTentativasRestantes());
    }

    @Test
    void deveLancarExcecaoParaLetraRepetida() {
        Partida partida = new Partida("JAVA", Categoria.OBJETO);
        partida.adivinhar('A');
        assertThrows(ForcaException.class, () -> partida.adivinhar('A'));
    }

    @Test
    void deveDetectarVitoria() {
        Partida partida = new Partida("OI", Categoria.OBJETO);
        partida.adivinhar('O');
        partida.adivinhar('I');
        assertTrue(partida.isVitoria());
    }

    @Test
    void deveDetectarDerrota() {
        Partida partida = new Partida("JAVA", Categoria.OBJETO);
        partida.adivinhar('B');
        partida.adivinhar('C');
        partida.adivinhar('D');
        partida.adivinhar('E');
        partida.adivinhar('F');
        partida.adivinhar('G');
        assertTrue(partida.isDerrota());
    }

    @Test
    void deveMostrarPalavraMascarada() {
        Partida partida = new Partida("JAVA", Categoria.OBJETO);
        partida.adivinhar('A');
        assertEquals("_ A _ A", partida.getPalavraMascarada());
    }
}
