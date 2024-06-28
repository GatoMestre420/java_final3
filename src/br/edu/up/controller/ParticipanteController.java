package br.edu.up.controller;

import br.edu.up.model.Participante;
import br.edu.up.view.ParticipanteView;

public class ParticipanteController {
   private Participante model;
    private ParticipanteView view;

    public ParticipanteController(Participante model, ParticipanteView view) {
        this.model = model;
        this.view = view;
    }

    public void setNomeParticipante(String nome) {
        model.setNome(nome);
    }

    public String getNomeParticipante() {
        return model.getNome();
    }

    public void atualizarView() {
        view.exibirDetalhesParticipante(model);
    }
}
