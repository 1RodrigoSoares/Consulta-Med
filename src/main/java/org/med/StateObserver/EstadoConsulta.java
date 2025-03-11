package org.med.StateObserver;

import org.med.Consulta;

public abstract class EstadoConsulta {
    public abstract String getEstado();

    public boolean cancelar(Consulta consulta){
        return false;
    };

    public boolean iniciar(Consulta consulta){
        return false;
    };

    public boolean concluir(Consulta consulta){
        return false;
    };

}