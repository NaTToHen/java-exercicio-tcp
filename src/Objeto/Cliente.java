package Objeto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Carro carro = new Carro("Gol", "ABC-1234");

        Socket socket = new Socket("localhost", 54321);

        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        saida.writeObject(carro);

        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream()); 
        Carro novaMensagem = (Carro)entrada.readObject();

        System.out.println("Modelo: " + novaMensagem.modelo + "\nPlaca: " + novaMensagem.placa);

        entrada.close();
        saida.close();
        socket.close();
    }
}
