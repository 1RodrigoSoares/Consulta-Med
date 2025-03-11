package org.med.Mediator;

public class Secretaria {

    private static Secretaria instancia = new Secretaria();

    private Secretaria() {}

    public static Secretaria getInstancia() {
        return instancia;
    }

    public String agendarConsulta() {
        return "Analisando o agendamento da consulta";
    }

    public String cancelarConsulta() {
        return "Analisando o pedido de cancelamento da consulta ";
    }

    public String remarcarConsulta() {
        return "Analisando o pedido de remarcarcação da consulta";
    }
}

