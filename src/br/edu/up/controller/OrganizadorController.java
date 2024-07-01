package br.edu.up.controller;

import br.edu.up.model.Organizador;
import br.edu.up.view.OrganizadorView;

public class OrganizadorController {
    private Organizador model;
    private OrganizadorView view;

    public OrganizadorController(Organizador model, OrganizadorView view) {
        this.model = model;
        this.view = view;
    }

    public void setNomeOrganizador(String nome) {
        model.setNome(nome);
    }

    public String getNomeOrganizador() {
        return model.getNome();
    }

    public void atualizarView() {
        view.exibirDetalhesOrganizador(model);
    }
}
