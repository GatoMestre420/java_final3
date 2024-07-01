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
    private static List<Participante> participantes = new ArrayList<>();
    private static List<Organizador> organizadores = new ArrayList<>();
    private static List<Local> locais = new ArrayList<>();

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Evento");
            System.out.println("2. Visualizar Eventos");
            System.out.println("3. Atualizar Evento");
            System.out.println("4. Excluir Evento");
            System.out.println("5. Adicionar Participante");
            System.out.println("6. Visualizar Participantes");
            System.out.println("7. Atualizar Participante");
            System.out.println("8. Excluir Participante");
            System.out.println("9. Adicionar Organizador");
            System.out.println("10. Visualizar Organizadores");
            System.out.println("11. Atualizar Organizador");
            System.out.println("12. Excluir Organizador");
            System.out.println("13. Adicionar Local");
            System.out.println("14. Visualizar Locais");
            System.out.println("15. Atualizar Local");
            System.out.println("16. Excluir Local");
            System.out.println("17. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

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
                    adicionarParticipante();
                    break;
                case 6:
                    visualizarParticipantes();
                    break;
                case 7:
                    atualizarParticipante();
                    break;
                case 8:
                    excluirParticipante();
                    break;
                case 9:
                    adicionarOrganizador();
                    break;
                case 10:
                    visualizarOrganizadores();
                    break;
                case 11:
                    atualizarOrganizador();
                    break;
                case 12:
                    excluirOrganizador();
                    break;
                case 13:
                    adicionarLocal();
                    break;
                case 14:
                    visualizarLocais();
                    break;
                case 15:
                    atualizarLocal();
                    break;
                case 16:
                    excluirLocal();
                    break;
                case 17:
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
        scanner.nextLine();  // Consumir a nova linha
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
            scanner.nextLine();  // Consumir a nova linha
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

    private static void adicionarParticipante() {
        System.out.println("Digite o nome do Participante:");
        String nomeParticipante = scanner.nextLine();
        Participante participante = new Participante(nomeParticipante);
        participantes.add(participante);
        ParticipanteView view = new ParticipanteView();
        ParticipanteController controller = new ParticipanteController(participante, view);
        controller.atualizarView();
    }

    private static void visualizarParticipantes() {
        for (Participante participante : participantes) {
            ParticipanteView view = new ParticipanteView();
            ParticipanteController controller = new ParticipanteController(participante, view);
            controller.atualizarView();
        }
    }

    private static void atualizarParticipante() {
        System.out.println("Digite o nome do Participante a ser atualizado:");
        String nomeParticipante = scanner.nextLine();
        Participante participante = buscarParticipante(nomeParticipante);
        if (participante != null) {
            ParticipanteView view = new ParticipanteView();
            ParticipanteController controller = new ParticipanteController(participante, view);

            System.out.println("Digite o novo nome do Participante:");
            String novoNome = scanner.nextLine();
            controller.setNomeParticipante(novoNome);

            controller.atualizarView();
        } else {
            System.out.println("Participante não encontrado.");
        }
    }

    private static void excluirParticipante() {
        System.out.println("Digite o nome do Participante a ser excluído:");
        String nomeParticipante = scanner.nextLine();
        Participante participante = buscarParticipante(nomeParticipante);
        if (participante != null) {
            participantes.remove(participante);
            System.out.println("Participante excluído com sucesso.");
        } else {
            System.out.println("Participante não encontrado.");
        }
    }

    private static Participante buscarParticipante(String nomeParticipante) {
        for (Participante participante : participantes) {
            if (participante.getNome().equalsIgnoreCase(nomeParticipante)) {
                return participante;
            }
        }
        return null;
    }

    private static void adicionarOrganizador() {
        System.out.println("Digite o nome do Organizador:");
        String nomeOrganizador = scanner.nextLine();
        Organizador organizador = new Organizador(nomeOrganizador);
        organizadores.add(organizador);
        OrganizadorView view = new OrganizadorView();
        OrganizadorController controller = new OrganizadorController(organizador, view);
        controller.atualizarView();
    }

    private static void visualizarOrganizadores() {
        for (Organizador organizador : organizadores) {
            OrganizadorView view = new OrganizadorView();
            OrganizadorController controller = new OrganizadorController(organizador, view);
            controller.atualizarView();
        }
    }

    private static void atualizarOrganizador() {
        System.out.println("Digite o nome do Organizador a ser atualizado:");
        String nomeOrganizador = scanner.nextLine();
        Organizador organizador = buscarOrganizador(nomeOrganizador);
        if (organizador != null) {
            OrganizadorView view = new OrganizadorView();
            OrganizadorController controller = new OrganizadorController(organizador, view);

            System.out.println("Digite o novo nome do Organizador:");
            String novoNome = scanner.nextLine();
            controller.setNomeOrganizador(novoNome);

            controller.atualizarView();
        } else {
            System.out.println("Organizador não encontrado.");
        }
    }

    private static void excluirOrganizador() {
        System.out.println("Digite o nome do Organizador a ser excluído:");
        String nomeOrganizador = scanner.nextLine();
        Organizador organizador = buscarOrganizador(nomeOrganizador);
        if (organizador != null) {
            organizadores.remove(organizador);
            System.out.println("Organizador excluído com sucesso.");
        } else {
            System.out.println("Organizador não encontrado.");
        }
    }

    private static Organizador buscarOrganizador(String nomeOrganizador) {
        for (Organizador organizador : organizadores) {
            if (organizador.getNome().equalsIgnoreCase(nomeOrganizador)) {
                return organizador;
            }
        }
        return null;
    }

    private static void adicionarLocal() {
        System.out.println("Digite o endereço do Local:");
        String enderecoLocal = scanner.nextLine();
        Local local = new Local(enderecoLocal);
        locais.add(local);
        LocalView view = new LocalView();
        LocalController controller = new LocalController(local, view);
        controller.atualizarView();
    }

    private static void visualizarLocais() {
        for (Local local : locais) {
            LocalView view = new LocalView();
            LocalController controller = new LocalController(local, view);
            controller.atualizarView();
        }
    }

    private static void atualizarLocal() {
        System.out.println("Digite o endereço do Local a ser atualizado:");
        String enderecoLocal = scanner.nextLine();
        Local local = buscarLocal(enderecoLocal);
        if (local != null) {
            LocalView view = new LocalView();
            LocalController controller = new LocalController(local, view);

            System.out.println("Digite o novo endereço do Local:");
            String novoEndereco = scanner.nextLine();
            controller.setEnderecoLocal(novoEndereco);

            controller.atualizarView();
        } else {
            System.out.println("Local não encontrado.");
        }
    }

    private static void excluirLocal() {
        System.out.println("Digite o endereço do Local a ser excluído:");
        String enderecoLocal = scanner.nextLine();
        Local local = buscarLocal(enderecoLocal);
        if (local != null) {
            locais.remove(local);
            System.out.println("Local excluído com sucesso.");
        } else {
            System.out.println("Local não encontrado.");
        }
    }

    private static Local buscarLocal(String enderecoLocal) {
        for (Local local : locais) {
            if (local.getEndereco().equalsIgnoreCase(enderecoLocal)) {
                return local;
            }
        }
        return null;
    }
}
