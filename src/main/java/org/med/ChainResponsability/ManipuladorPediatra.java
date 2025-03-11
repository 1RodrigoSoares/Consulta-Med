package org.med.ChainResponsability;

public class ManipuladorPediatra extends ManipuladorEncaminhamento {

    public ManipuladorPediatra(ManipuladorEncaminhamento proximo) {
        super(proximo);
    }

    @Override
    public String manipularSolicitacao(String especialidade) {
        if ("Pediatria".equalsIgnoreCase(especialidade)) {
            return "Encaminhado ao Pediatra";
        } else {
            if (this.proximoManipulador != null) {
                return this.proximoManipulador.manipularSolicitacao(especialidade);
            }
            return "Sem encaminhamento disponível para a especialidade: " + especialidade;
        }
    }
}