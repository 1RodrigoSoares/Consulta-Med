package org.med.ChainResponsability;

public class ManipuladorCardiologista extends ManipuladorEncaminhamento {

    public ManipuladorCardiologista(ManipuladorEncaminhamento proximo) {
        super(proximo);
    }

    @Override
    public String manipularSolicitacao(String especialidade) {
        if ("Cardiologia".equalsIgnoreCase(especialidade)) {
            return "Encaminhado ao Cardiologista";
        } else {
            if (this.proximoManipulador != null) {
                return this.proximoManipulador.manipularSolicitacao(especialidade);
            }
            return "Sem encaminhamento disponível para a especialidade: " + especialidade;
        }
    }
}