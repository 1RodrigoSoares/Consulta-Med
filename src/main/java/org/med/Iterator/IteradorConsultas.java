package org.med.Iterator;
import org.med.Consulta;

import java.util.List;

public class IteradorConsultas implements Iterador<Consulta> {
    private List<Consulta> consultas;
    private int indice = 0;

    public IteradorConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public boolean temProximo() {
        return indice < consultas.size();
    }

    @Override
    public Consulta proximo() {
        return consultas.get(indice++);
    }
}