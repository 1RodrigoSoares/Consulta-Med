package org.med.ChainResponsability;

public class ManipuladorGeneralista extends ManipuladorEncaminhamento {

    public ManipuladorGeneralista(ManipuladorEncaminhamento proximo) {
        super(proximo);
    }

    @Override
    public String manipularSolicitacao(String especialidade) {
        if ("Geral".equalsIgnoreCase(especialidade)) {
            return "Consulta atendida pelo Generalista";
        } else {
            if (this.proximoManipulador != null) {
                return this.proximoManipulador.manipularSolicitacao(especialidade);
            }
            return "Sem encaminhamento disponível para a especialidade: " + especialidade;
        }
    }
}