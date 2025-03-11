package org.med;
import org.med.TemplateMethod.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TemplateMethodTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testTratarPrioridadeEmergencia() {
        ProcessoConsulta emergencia = new ProcessoEmergencia();
        emergencia.tratarPrioridade();

        String expectedOutput = "Prioridade alta: Acionando equipe de emergência imediatamente!" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testTratarPrioridadeAgendada() {
        ProcessoConsulta agendada = new ProcessoAgendada();
        agendada.tratarPrioridade();

        String expectedOutput = "Não há prioridade" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}
