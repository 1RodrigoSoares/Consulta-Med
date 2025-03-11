package org.med;
import org.med.ChainResponsability.ManipuladorEncaminhamento;
import org.med.ChainResponsability.ManipuladorGeneralista;
import org.med.StateObserver.EstadoAgendada;
import org.med.StateObserver.EstadoConsulta;
import org.med.StateObserver.Paciente;

import java.util.Observable;

import java.time.LocalDateTime;

public class Consulta extends Observable{
    private String paciente;
    private LocalDateTime data;
    private String tipo;
    private EstadoConsulta estado;
    private ManipuladorEncaminhamento encaminhamentoInicial;

    public Consulta(String tipo, ManipuladorEncaminhamento encaminhamentoInicial) {
        this.estado = new EstadoAgendada();
        this.encaminhamentoInicial = encaminhamentoInicial;
        this.tipo = tipo;
    }

    public Consulta(String tipo) {
        this(tipo, new ManipuladorGeneralista(null));
    }

    public String getTipo() {
        return tipo;
    }

    public void setEstado(EstadoConsulta novoEstado) {
        this.estado = novoEstado;
        setChanged();
        notifyObservers(novoEstado.getEstado());
    }

    public String getEstadoAtual() {
        return estado.getEstado();
    }

    public boolean cancelar(){
        return estado.cancelar(this);
    };

    public boolean iniciar( ){
        return estado.iniciar(this);
    };

    public boolean concluir(){
        return estado.concluir(this);
    };

    public void vincularPaciente(Paciente paciente) {
        this.addObserver(paciente);
    }

    public String processarEncaminhamento(String especialidade) {
        return encaminhamentoInicial.manipularSolicitacao(especialidade);
    }
}

