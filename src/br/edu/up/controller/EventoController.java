package br.edu.up.controller;

import java.util.List;

import br.edu.up.model.Evento;
import br.edu.up.model.Local;
import br.edu.up.model.Organizador;
import br.edu.up.model.Participante;
import br.edu.up.view.EventoView;

public class EventoController {
   private Evento model;
    private EventoView view;

    public EventoController(Evento model, EventoView view) {
        this.model = model;
        this.view = view;
    }

    public void setNomeEvento(String nome) {
        model.setNome(nome);
    }

    public String getNomeEvento() {
        return model.getNome();
    }

    public void setOrganizadorEvento(Organizador organizador) {
        model.setOrganizador(organizador);
    }

    public Organizador getOrganizadorEvento() {
        return model.getOrganizador();
    }

    public void setLocalEvento(Local local) {
        model.setLocal(local);
    }

    public Local getLocalEvento() {
        return model.getLocal();
    }

    public void setParticipantesEvento(List<Participante> participantes) {
        model.setParticipantes(participantes);
    }

    public List<Participante> getParticipantesEvento() {
        return model.getParticipantes();
    }

    public void atualizarView() {
        view.exibirDetalhesEvento(model);
    }
}
