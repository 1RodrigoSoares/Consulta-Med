package org.med;

import org.med.Factory.*;
import org.med.Iterator.*;
import org.med.Strategy.*;


public class GerenciadorDeConsultas {
    private static GerenciadorDeConsultas instancia;
    private ListaConsultas listaConsultas = new ListaConsultas();
    private PoliticaAgendamento politicaAgendamento;

    private GerenciadorDeConsultas() {}

    public static GerenciadorDeConsultas getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorDeConsultas();
        }
        return instancia;
    }

    public Consulta criarConsulta(FabricaConsulta fabrica) {
        Consulta consulta = fabrica.criarConsulta();
        listaConsultas.adicionarConsulta(consulta, null);
        return consulta;
    }

    public void listarConsultas() {
        Iterador<Consulta> iterador = listaConsultas.criarIterador();
        while (iterador.temProximo()) {
            Consulta consulta = iterador.proximo();
            System.out.println(consulta.getTipo());
        }
    }

    public ListaConsultas getListaConsultas() {
        return listaConsultas;
    }

    public void limparConsultas() {
        this.listaConsultas = new ListaConsultas();
    }

    public void aplicarEstrategiaAgendamento(PoliticaAgendamento politicaAgendamento, Consulta consulta) {
        this.politicaAgendamento = politicaAgendamento;
        politicaAgendamento.agendar(consulta, listaConsultas);
    }

}