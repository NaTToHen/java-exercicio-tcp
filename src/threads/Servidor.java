package threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(54321);
        System.out.println("A porta 54321 esta aberta");
        System.out.println("Aguardando receber mensagem de cliente");

        while(true) {
            Socket socket = serverSocket.accept();

            ThreadsSockets thread = new ThreadsSockets(socket);
            thread.start();

            System.out.println("Cliente " + socket.getInetAddress().getHostAddress() +
            " conectado, Thread: " + thread.getName());
        }
    }
}
