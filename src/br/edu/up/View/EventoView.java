package br.edu.up.view;

import br.edu.up.model.Evento;

public class EventoView {
    public void exibirDetalhesEvento(Evento evento) {
        System.out.println("Nome do Evento: " + evento.getNome());
        System.out.println("Organizador: " + evento.getOrganizador().getNome());
        System.out.println("Local: " + evento.getLocal().getEndereco());
        System.out.println("Participantes: ");
        evento.getParticipantes().forEach(p -> System.out.println(p.getNome()));
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
