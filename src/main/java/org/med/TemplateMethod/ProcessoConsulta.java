package org.med.TemplateMethod;

public abstract class ProcessoConsulta {
    public final void realizarProcesso() {
        realizarCheckin();
        tratarPrioridade();
        realizarExame();
        finalizarProcesso();
    }

    public void realizarCheckin() {
        System.out.println("Check-in realizado");
    }

    public abstract void tratarPrioridade();

    public abstract void realizarExame();

    public void finalizarProcesso() {
        System.out.println("Processo finalizado");
    }
}
