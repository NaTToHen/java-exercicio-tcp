package Objeto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

   public static void main(String[] args) throws IOException, ClassNotFoundException {

      ServerSocket serverSocket = new ServerSocket(54321);
      System.out.println("A porta 54321 esta aberta");
      System.out.println("Aguardando receber mensagem de cliente");

      Socket socket = serverSocket.accept();
      System.out.println("Cliente :" + socket.getInetAddress().getHostAddress() + " conectado");

      ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
      Carro carro = (Carro)entrada.readObject();

      ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
      saida.writeObject(carro);

      entrada.close();
      saida.close();
      serverSocket.close();
      socket.close();
   }
}
