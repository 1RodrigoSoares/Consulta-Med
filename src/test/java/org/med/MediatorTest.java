package org.med;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.med.StateObserver.*;

public class MediatorTest {
    @Test
    void deveSolicitarAgendamento() {
        Paciente paciente = new Paciente("João");
        String mensagem = "Consulta de rotina";
        String respostaEsperada = "A Secretaria recebeu sua solicitação: \n" +
                ">> Analisando o agendamento da consulta";
        assertEquals(respostaEsperada, paciente.solicitarAgendamento(mensagem));
    }

    @Test
    void deveSolicitarCancelamento() {
        Paciente paciente = new Paciente("Maria");
        String mensagem = "Cancelar consulta de retorno";
        String respostaEsperada = "A Secretaria recebeu sua solicitação:\n" +
                ">> Analisando o pedido de cancelamento da consulta ";
        assertEquals(respostaEsperada, paciente.solicitarCancelamento(mensagem));
    }

    @Test
    void deveSolicitarRemarcacao() {
        Paciente paciente = new Paciente("Carlos");
        String mensagem = "Remarcar consulta para próxima semana";
        String respostaEsperada = "A Secretaria recebeu sua solicitação:\n" +
                ">> Analisando o pedido de remarcarcação da consulta";
        assertEquals(respostaEsperada, paciente.solicitarRemarcacao(mensagem));
    }
}
