package org.med.Strategy;

import org.med.Consulta;
import org.med.Iterator.ListaConsultas;

public class PoliticaEncaixe implements PoliticaAgendamento {
    @Override
    public void agendar(Consulta consulta, ListaConsultas listaConsultas) {
        listaConsultas.adicionarConsulta( consulta, null);
        System.out.println("Agendado por lista de espera");
    }
}
