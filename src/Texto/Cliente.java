package Texto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 54321);

        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF("afonso padilha");

        DataInputStream entrada = new DataInputStream(socket.getInputStream()); 
        String novaMensagem = entrada.readUTF();

        System.out.println(novaMensagem);

        entrada.close();
        saida.close();

        socket.close();
    }
}
