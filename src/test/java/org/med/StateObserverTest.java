package org.med;
import org.med.StateObserver.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StateObserverTest {
    private Consulta consulta;
    private Paciente paciente;

    @BeforeEach
    void setUp() {
        consulta = new Consulta("Emergencial");
        paciente = new Paciente("Ana");
        consulta.vincularPaciente(paciente);
    }

    @Test
    void deveCancelarConsultaQuandoAgendada() {
        boolean sucesso = consulta.cancelar();

        assertTrue(sucesso);
        assertEquals("Cancelada", consulta.getEstadoAtual());
        assertEquals("Cancelada", paciente.getUltimaNotificacao());
    }

    @Test
    void deveIniciarConsultaQuandoAgendada() {
        boolean sucesso = consulta.iniciar();

        assertTrue(sucesso);
        assertEquals("Em Andamento", consulta.getEstadoAtual());
        assertEquals("Em Andamento", paciente.getUltimaNotificacao());
    }

    @Test
    void deveFalharAoConcluirConsultaAgendada() {
        boolean sucesso = consulta.concluir();

        assertFalse(sucesso);
        assertEquals("Agendada", consulta.getEstadoAtual());
        assertNull(paciente.getUltimaNotificacao());
    }

    @Test
    void deveConcluirConsultaQuandoEmAndamento() {
        consulta.iniciar();

        boolean sucesso = consulta.concluir();

        assertTrue(sucesso);
        assertEquals("Concluida", consulta.getEstadoAtual());
        assertEquals("Concluida", paciente.getUltimaNotificacao());
    }

    @Test
    void deveCancelarConsultaQuandoEmAndamento() {
        consulta.iniciar();

        boolean sucesso = consulta.cancelar();

        assertTrue(sucesso);
        assertEquals("Cancelada", consulta.getEstadoAtual());
        assertEquals("Cancelada", paciente.getUltimaNotificacao());
    }

    @Test
    void deveFalharAoCancelarConsultaCancelada() {
        consulta.cancelar();

        boolean sucesso = consulta.cancelar();

        assertFalse(sucesso);
        assertEquals("Cancelada", consulta.getEstadoAtual());
        assertEquals("Cancelada", paciente.getUltimaNotificacao());
    }

    @Test
    void deveFalharAoIniciarConsultaCancelada() {
        consulta.cancelar();

        boolean sucesso = consulta.iniciar();

        assertFalse(sucesso);
        assertEquals("Cancelada", consulta.getEstadoAtual());
    }

    @Test
    void deveFalharAoCancelarConsultaConcluida() {
        consulta.iniciar();
        consulta.concluir();

        boolean sucesso = consulta.cancelar();

        assertFalse(sucesso);
        assertEquals("Concluida", consulta.getEstadoAtual());
    }

    @Test
    void deveFalharAoConcluirConsultaJaConcluida() {
        consulta.iniciar();
        consulta.concluir();

        boolean sucesso = consulta.concluir();

        assertFalse(sucesso);
        assertEquals("Concluida", consulta.getEstadoAtual());
    }
}
