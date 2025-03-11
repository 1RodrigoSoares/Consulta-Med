package org.med.StateObserver;

public class EstadoConcluida extends EstadoConsulta {
    private static EstadoConcluida instance = new EstadoConcluida();
    public static EstadoConcluida getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Concluida";
    }
}