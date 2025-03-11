package org.med.TemplateMethod;

public class ProcessoEmergencia extends ProcessoConsulta {
    @Override
    public void tratarPrioridade() {
        System.out.println("Prioridade alta: Acionando equipe de emergência imediatamente!");
    }

    @Override
    public void realizarExame() {
        System.out.println("Realizando exames rápidos de emergência");
    }
}
