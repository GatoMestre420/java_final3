package br.edu.up.model;

import java.util.List;

public class Evento {
    private String nome;
    private Organizador organizador;
    private Local local;
    private List<Participante> participantes; 

    public Evento(String nome, Organizador organizador, Local local, List<Participante> participantes) {
        this.nome = nome;
        this.organizador = organizador;
        this.local = local;
        this.participantes = participantes;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}
