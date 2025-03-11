package org.med.StateObserver;

import org.med.Consulta;

public class EstadoAgendada extends EstadoConsulta {
    private static EstadoAgendada instance = new EstadoAgendada();
    public static EstadoAgendada getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Agendada";
    }

    @Override
    public boolean cancelar(Consulta consulta){
        consulta.setEstado(EstadoCancelada.getInstance());
        return true;
    };

    @Override
    public boolean iniciar(Consulta consulta){
        consulta.setEstado(EstadoEmAndamento.getInstance());
        return true;
    };
}