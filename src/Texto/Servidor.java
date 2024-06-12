package Texto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

   public static void main(String[] args) throws IOException {

      ServerSocket serverSocket = new ServerSocket(54321);
      System.out.println("A porta 54321 esta aberta");
      System.out.println("Aguardando receber mensagem de cliente");

      Socket socket = serverSocket.accept();
      System.out.println("Cliente :" + socket.getInetAddress().getHostAddress() + " conectado");

      DataInputStream entrada = new DataInputStream(socket.getInputStream());
      String msg = entrada.readUTF();
      String novaMsg = msg.toUpperCase();

      DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
      saida.writeUTF(novaMsg);

      entrada.close();
      saida.close();
      serverSocket.close();
      socket.close();
   }
}
