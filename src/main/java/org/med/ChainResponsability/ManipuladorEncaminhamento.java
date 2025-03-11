package org.med.ChainResponsability;

public abstract class ManipuladorEncaminhamento {

    protected ManipuladorEncaminhamento proximoManipulador;

    public ManipuladorEncaminhamento(ManipuladorEncaminhamento proximo) {
        this.proximoManipulador = proximo;
    }

    public abstract String manipularSolicitacao(String especialidade);
}