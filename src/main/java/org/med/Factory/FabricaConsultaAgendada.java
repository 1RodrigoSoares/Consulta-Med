package org.med.Factory;

import org.med.Consulta;

public class FabricaConsultaAgendada extends FabricaConsulta {
    @Override
    public Consulta criarConsulta() {
        return new Consulta("Agendada");
    }
}