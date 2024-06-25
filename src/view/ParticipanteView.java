package br.edu.up.view;

import br.edu.up.model.Participante;

public class ParticipanteView {
     public void exibirDetalhesParticipante(Participante participante) {
        System.out.println("Nome do Participante: " + participante.getNome());
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
