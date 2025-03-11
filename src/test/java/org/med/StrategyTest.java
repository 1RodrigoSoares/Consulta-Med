package org.med;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.med.Iterator.Iterador;
import org.med.Strategy.*;
import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {
    @BeforeEach
    void setUp() {
        GerenciadorDeConsultas gerenciador = GerenciadorDeConsultas.getInstancia();
        gerenciador.limparConsultas();
    }

    @Test
    void deveAgendarPorOrdemChegada() {
        GerenciadorDeConsultas gerenciador = GerenciadorDeConsultas.getInstancia();
        PoliticaAgendamento estrategia = new PoliticaEncaixe();
        Consulta consulta1 = new Consulta("Rotina");
        Consulta consulta2 = new Consulta("Emergencial");

        gerenciador.aplicarEstrategiaAgendamento(estrategia, consulta1);
        gerenciador.aplicarEstrategiaAgendamento(estrategia, consulta2);

        Iterador<Consulta> iterador = gerenciador.getListaConsultas().criarIterador();


        assertTrue(iterador.temProximo());
        assertEquals(consulta1, iterador.proximo());

        assertTrue(iterador.temProximo());
        assertEquals(consulta2, iterador.proximo());

        assertFalse(iterador.temProximo());
    }

    @Test
    void devePriorizarEmergencias() {
        GerenciadorDeConsultas gerenciador = GerenciadorDeConsultas.getInstancia();
        PoliticaAgendamento estrategia = new PoliticaPrioritaria();
        Consulta consulta1 = new Consulta("Rotina");
        Consulta consulta2 = new Consulta("Emergência");

        gerenciador.aplicarEstrategiaAgendamento(estrategia, consulta1);
        gerenciador.aplicarEstrategiaAgendamento(estrategia, consulta2);

        Iterador<Consulta> iterador = gerenciador.getListaConsultas().criarIterador();

        assertTrue(iterador.temProximo());
        assertEquals(consulta2, iterador.proximo());

        assertTrue(iterador.temProximo());
        assertEquals(consulta1, iterador.proximo());

        assertFalse(iterador.temProximo());
    }
}
