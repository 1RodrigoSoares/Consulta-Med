package org.med;

import org.junit.jupiter.api.*;
import org.med.ChainResponsability.*;

import static org.junit.jupiter.api.Assertions.*;


public class ChainResponsabilityTest {
    private ManipuladorEncaminhamento chain;

    @BeforeEach
    void setUp() {
        chain = new ManipuladorGeneralista(
                new ManipuladorPediatra(
                        new ManipuladorCardiologista(null)
                )
        );
    }

    @Test
    void deveSerAtendidoPeloGeneralista() {
        String resposta = chain.manipularSolicitacao("Geral");
        assertEquals("Consulta atendida pelo Generalista", resposta);
    }

    @Test
    void deveSerEncaminhadoAoPediatra() {
        String resposta = chain.manipularSolicitacao("Pediatria");
        assertEquals("Encaminhado ao Pediatra", resposta);
    }

    @Test
    void deveSerEncaminhadoAoCardiologista() {
        String resposta = chain.manipularSolicitacao("Cardiologia");
        assertEquals("Encaminhado ao Cardiologista", resposta);
    }

    @Test
    void deveRetornarSemEncaminhamento() {
        String resposta = chain.manipularSolicitacao("Oftalmologia");
        assertEquals("Sem encaminhamento disponível para a especialidade: Oftalmologia", resposta);
    }
}
