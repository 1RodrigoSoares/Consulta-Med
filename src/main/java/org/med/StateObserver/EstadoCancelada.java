package org.med.StateObserver;

public class EstadoCancelada extends EstadoConsulta {
    private static EstadoCancelada instance = new EstadoCancelada();
    public static EstadoCancelada getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Cancelada";
    }
}