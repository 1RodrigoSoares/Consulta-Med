package org.med.TemplateMethod;

public class ProcessoAgendada extends ProcessoConsulta {
    @Override
    public void tratarPrioridade() {
        System.out.println("Não há prioridade");
    }

    @Override
    public void realizarExame() {
        System.out.println("Realizando exames programados");
    }

    @Override
    public void finalizarProcesso() {
        System.out.println("Agendar retorno");
        super.finalizarProcesso();
    }
}
