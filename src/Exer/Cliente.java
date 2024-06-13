package Exer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String servidor = "localhost";
        int porta = 51296;

        while (true) {
            System.out.println("\n1. Enviar Pretendente ao Servidor");
            System.out.println("2. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("Digite o nome:");
                String nome = scanner.nextLine();
                System.out.println("Digite a idade:");
                int idade = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Digite a pretensão:");
                String pretencao = scanner.nextLine();

                Pretendente pretendente = new Pretendente(nome, idade, pretencao);

                try {
                    Socket socket = new Socket(servidor, porta);
                    ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
                    saida.writeObject(pretendente);

                    ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
                    String resposta = (String) entrada.readObject();

                    System.out.println("Resposta do servidor: " + resposta);

                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao == 2) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }

        scanner.close();
    }
}
