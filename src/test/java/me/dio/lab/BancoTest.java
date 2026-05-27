package me.dio.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BancoTest {

    @Test
    void testCriacaoContaEDeposito() {
        Cliente cliente = new Cliente("Alice", "123");
        Conta cc = new ContaCorrente(cliente);
        cc.depositar(100.0);

        assertEquals(100.0, cc.getSaldo());
        assertEquals("Alice", cc.getCliente().nome());
    }

    @Test
    void testTransferencia() {
        Cliente c1 = new Cliente("Alice", "123");
        Cliente c2 = new Cliente("Bob", "456");
        Conta cc = new ContaCorrente(c1);
        Conta cp = new ContaPoupanca(c2);

        cc.depositar(100.0);
        boolean sucesso = cc.transferir(50.0, cp);

        assertTrue(sucesso);
        assertEquals(50.0, cc.getSaldo());
        assertEquals(50.0, cp.getSaldo());
    }

    @Test
    void testInvestimento() {
        Cliente cliente = new Cliente("Alice", "123");
        Conta cc = new ContaCorrente(cliente);
        cc.depositar(1000.0);

        boolean sucesso = cc.criarInvestimento("CDB", 500.0, 0.1);

        assertTrue(sucesso);
        assertEquals(500.0, cc.getSaldo());
        assertFalse(cc.getInvestimentos().isEmpty());
        assertEquals("CDB", cc.getInvestimentos().get(0).getNome());
    }
}
