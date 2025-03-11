package org.med;

import org.junit.jupiter.api.*;
import org.med.Factory.*;
import org.med.Iterator.*;
import static org.junit.jupiter.api.Assertions.*;


class GerenciadorDeConsultasTest {

    private GerenciadorDeConsultas gerenciador;

    @BeforeEach
    void setUp() {
        gerenciador = GerenciadorDeConsultas.getInstancia();
        gerenciador.limparConsultas();
    }

    @Test
    void deveRetornarInstanciaUnica() {
        GerenciadorDeConsultas outraInstancia = GerenciadorDeConsultas.getInstancia();
        assertSame(gerenciador, outraInstancia, "Instâncias devem ser a mesma");
    }

    @Test
    void deveListarConsultasQuandoListaPreenchida() {
        gerenciador.criarConsulta(new FabricaConsultaEmergencial());
        gerenciador.criarConsulta(new FabricaConsultaAgendada());

        Iterador<Consulta> iterador = gerenciador.getListaConsultas().criarIterador();
        assertTrue(iterador.temProximo(), "Deveria ter consultas na lista");

        Consulta primeira = iterador.proximo();
        assertEquals("Emergencial", primeira.getTipo(), "Primeira consulta deveria ser emergência");

        assertTrue(iterador.temProximo(), "Deveria ter segunda consulta");
        Consulta segunda = iterador.proximo();
        assertEquals("Agendada", segunda.getTipo(), "Segunda consulta deveria ser agendada");
    }
}