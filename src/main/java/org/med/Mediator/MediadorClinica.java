package org.med.Mediator;

public class MediadorClinica {
    private static MediadorClinica instancia = new MediadorClinica();

    private MediadorClinica() {}

    public static MediadorClinica getInstancia() {
        return instancia;
    }

    public String receberAgendamento(String mensagem) {
        return "A Secretaria recebeu sua solicitação: \n" +
                ">> " + Secretaria.getInstancia().agendarConsulta();
    }

    public String receberCancelamento(String mensagem) {
        return "A Secretaria recebeu sua solicitação:\n" +
                ">> " + Secretaria.getInstancia().cancelarConsulta();
    }

    public String receberRemarcacao(String mensagem) {
        return "A Secretaria recebeu sua solicitação:\n" +
                ">> " + Secretaria.getInstancia().remarcarConsulta();
    }
}