package br.edu.up;

import br.edu.up.model.*;
import br.edu.up.controller.*;
import br.edu.up.view.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Evento> eventos = new ArrayList<>();

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Evento");
            System.out.println("2. Visualizar Eventos");
            System.out.println("3. Atualizar Evento");
            System.out.println("4. Excluir Evento");
            System.out.println("5. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    adicionarEvento();
                    break;
                case 2:
                    visualizarEventos();
                    break;
                case 3:
                    atualizarEvento();
                    break;
                case 4:
                    excluirEvento();
                    break;
                case 5:
                    sair = true;
                    break;

                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }

    private static void adicionarEvento() {
        System.out.println("Digite o nome do Evento:");
        String nomeEvento = scanner.nextLine();

        System.out.println("Digite o nome do Organizador do Evento:");
        String nomeOrganizador = scanner.nextLine();
        Organizador organizador = new Organizador(nomeOrganizador);

        System.out.println("Digite o endereço do Local do Evento:");
        String enderecoLocal = scanner.nextLine();
        Local local = new Local(enderecoLocal);

        List<Participante> participantesEvento = new ArrayList<>();
        System.out.println("Digite o número de Participantes:");
        int numParticipantes = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        for (int i = 0; i < numParticipantes; i++) {
            System.out.println("Digite o nome do Participante " + (i + 1) + ":");
            String nomeParticipante = scanner.nextLine();
            participantesEvento.add(new Participante(nomeParticipante));
        }

        Evento evento = new Evento(nomeEvento, organizador, local, participantesEvento);
        eventos.add(evento);
        EventoView view = new EventoView();
        EventoController controller = new EventoController(evento, view);
        controller.atualizarView();
    }

    private static void visualizarEventos() {
        for (Evento evento : eventos) {
            EventoView view = new EventoView();
            EventoController controller = new EventoController(evento, view);
            controller.atualizarView();
        }
    }

    private static void atualizarEvento() {
        System.out.println("Digite o nome do Evento a ser atualizado:");
        String nomeEvento = scanner.nextLine();
        Evento evento = buscarEvento(nomeEvento);
        if (evento != null) {
            EventoView view = new EventoView();
            EventoController controller = new EventoController(evento, view);

            System.out.println("Digite o novo nome do Evento:");
            String novoNome = scanner.nextLine();
            controller.setNomeEvento(novoNome);

            System.out.println("Digite o novo nome do Organizador do Evento:");
            String novoNomeOrganizador = scanner.nextLine();
            Organizador novoOrganizador = new Organizador(novoNomeOrganizador);
            controller.setOrganizadorEvento(novoOrganizador);

            System.out.println("Digite o novo endereço do Local do Evento:");
            String novoEnderecoLocal = scanner.nextLine();
            Local novoLocal = new Local(novoEnderecoLocal);
            controller.setLocalEvento(novoLocal);

            List<Participante> novosParticipantes = new ArrayList<>();
            System.out.println("Digite o número de novos Participantes:");
            int numParticipantes = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            for (int i = 0; i < numParticipantes; i++) {
                System.out.println("Digite o nome do novo Participante " + (i + 1) + ":");
                String nomeParticipante = scanner.nextLine();
                novosParticipantes.add(new Participante(nomeParticipante));
            }
            controller.setParticipantesEvento(novosParticipantes);

            controller.atualizarView();
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    private static void excluirEvento() {
        System.out.println("Digite o nome do Evento a ser excluído:");
        String nomeEvento = scanner.nextLine();
        Evento evento = buscarEvento(nomeEvento);
        if (evento != null) {
            eventos.remove(evento);
            System.out.println("Evento excluído com sucesso.");
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    private static Evento buscarEvento(String nomeEvento) {
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nomeEvento)) {
                return evento;
            }
        }
        return null;
    }

}
