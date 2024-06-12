package Objeto;

import java.io.Serializable;

public class Carro implements Serializable {
   public String modelo;
   public String placa;
   public String cor;
   public String ano;


   public Carro(String modelo, String placa) {
      this.modelo = modelo;
      this.placa = placa;
   }

   public String getModelo() {
      return modelo;
   }

   public void setModelo(String modelo) {
      this.modelo = modelo;
   }

   public String getPlaca() {
      return placa;
   }

   public void setPlaca(String placa) {
      this.placa = placa;
   }
}
