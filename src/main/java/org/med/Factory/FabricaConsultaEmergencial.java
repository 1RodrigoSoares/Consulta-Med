package org.med.Factory;

import org.med.Consulta;

public class FabricaConsultaEmergencial extends FabricaConsulta {
    @Override
    public Consulta criarConsulta() {
        return new Consulta("Emergencial");
    }
}