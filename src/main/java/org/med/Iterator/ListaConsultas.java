package org.med.Iterator;
import org.med.Consulta;

import java.util.ArrayList;
import java.util.List;

public class ListaConsultas implements AgregadoConsultas {
    private List<Consulta> consultas = new ArrayList<>();

    public void adicionarConsulta(Consulta consulta, Integer index) {
        if(index == null)
        {
            consultas.add(consulta);
        }else {
            consultas.add(index, consulta);
        }
    }

    @Override
    public Iterador<Consulta> criarIterador() {
        return new IteradorConsultas(this.consultas);
    }
}