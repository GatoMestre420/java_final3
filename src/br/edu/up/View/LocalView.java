package br.edu.up.view;

import br.edu.up.model.Local;

public class LocalView {
    public void exibirDetalhesLocal(Local local) {
        System.out.println("Endereço do Local: " + local.getEndereco());
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
