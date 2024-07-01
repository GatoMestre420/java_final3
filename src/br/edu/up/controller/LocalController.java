package br.edu.up.controller;

import br.edu.up.model.Local;
import br.edu.up.view.LocalView;

public class LocalController {
    private Local model;
    private LocalView view;

    public LocalController(Local model, LocalView view) {
        this.model = model;
        this.view = view;
    }

    public void setEnderecoLocal(String endereco) {
        model.setEndereco(endereco);
    }

    public String getEnderecoLocal() {
        return model.getEndereco();
    }

    public void atualizarView() {
        view.exibirDetalhesLocal(model);
    }
}
