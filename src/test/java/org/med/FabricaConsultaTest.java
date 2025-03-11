package org.med.Factory;

import org.junit.jupiter.api.Test;
import org.med.Consulta;

import static org.junit.jupiter.api.Assertions.*;

class FabricaConsultaTest {

    @Test
    void deveCriarConsultaEmergencial() {
        FabricaConsulta fabrica = new FabricaConsultaEmergencial();
        Consulta consulta = fabrica.criarConsulta();
        assertEquals("Emergencial", consulta.getTipo());
    }

    @Test
    void deveCriarConsultaAgendada() {
        FabricaConsulta fabrica = new FabricaConsultaAgendada();
        Consulta consulta = fabrica.criarConsulta();
        assertEquals("Agendada", consulta.getTipo());
    }
}
