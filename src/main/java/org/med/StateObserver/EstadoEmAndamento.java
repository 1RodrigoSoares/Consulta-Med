package org.med.StateObserver;

import org.med.Consulta;

public class EstadoEmAndamento extends EstadoConsulta{
    private static EstadoEmAndamento instance = new EstadoEmAndamento();
    public static EstadoEmAndamento getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em Andamento";
    }

    public boolean cancelar(Consulta consulta){
        consulta.setEstado(EstadoCancelada.getInstance());
        return true;
    };

    public boolean concluir(Consulta consulta){
        consulta.setEstado(EstadoConcluida.getInstance());
        return true;
    };

}