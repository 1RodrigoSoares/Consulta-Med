package org.med.StateObserver;

import org.med.Mediator.MediadorClinica;

import java.util.Observer;
import java.util.Observable;

public class Paciente implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Paciente(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(Observable origem, Object mensagem) {
        this.ultimaNotificacao = (String) mensagem;
        System.out.println(nome + " notificado: " + mensagem);
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public String solicitarAgendamento(String mensagem) {
        return MediadorClinica.getInstancia().receberAgendamento(mensagem);
    }

    public String solicitarCancelamento(String mensagem) {
        return MediadorClinica.getInstancia().receberCancelamento(mensagem);
    }

    public String solicitarRemarcacao(String mensagem) {
        return MediadorClinica.getInstancia().receberRemarcacao(mensagem);
    }
}