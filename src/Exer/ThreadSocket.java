package Exer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadSocket extends Thread {
    private Socket socket;

    public ThreadSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            Pretendente pretendente = (Pretendente) entrada.readObject();

            System.out.println("Recebido: \n Nome: " + pretendente.getNome() + "\n Idade: " + pretendente.getIdade() + "\n Pretensão: " + pretendente.getPretencao());

            String resposta = "Aceito";
            if (pretendente.getIdade() < 18) {
                resposta = "Não aceito";
            }

            ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
            saida.writeObject(resposta);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
