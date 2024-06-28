package br.edu.up.view;

import br.edu.up.model.Organizador;

public class OrganizadorView {
    public void exibirDetalhesOrganizador(Organizador organizador) {
        System.out.println("Nome do Organizador: " + organizador.getNome());
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
