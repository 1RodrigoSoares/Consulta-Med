package org.med.Strategy;

import org.med.Consulta;
import org.med.Iterator.ListaConsultas;

public interface PoliticaAgendamento {
    void agendar(Consulta consulta, ListaConsultas listaConsultas);
}