package org.med.Strategy;

import org.med.Consulta;
import org.med.Iterator.ListaConsultas;

public class PoliticaPrioritaria implements PoliticaAgendamento {
    @Override
    public void agendar(Consulta consulta, ListaConsultas listaConsultas) {
        listaConsultas.adicionarConsulta( consulta, 0);
        System.out.println("Agendado com prioridade");
    }
}