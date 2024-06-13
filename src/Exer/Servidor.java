package Exer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(51296);
        System.out.println("A porta 51296 está aberta");
        System.out.println("Aguardando receber mensagem de cliente");

        while (true) {
            Socket socket = serverSocket.accept();

            ThreadSocket thread = new ThreadSocket(socket);
            thread.start();

            System.out.println("\n\nCliente " + socket.getInetAddress().getHostAddress() + " conectado na Thread " + thread.getName());
        }
    }
}
