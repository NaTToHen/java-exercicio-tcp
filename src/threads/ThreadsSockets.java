package threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ThreadsSockets extends Thread {
    private Socket socket;

    public ThreadsSockets(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            String mensagem = entrada.readUTF();
            String novaMensagem = mensagem.toUpperCase();

            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            saida.writeUTF(novaMensagem);

            entrada.close();
            saida.close();

            socket.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
