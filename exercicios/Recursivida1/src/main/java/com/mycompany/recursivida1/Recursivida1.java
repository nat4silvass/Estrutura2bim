
package com.mycompany.recursivida1;

public class Recursivida1 {
 public static void main(String[] args) {
      int resultado = somar(0, 50);
        System.out.println("A soma de 0 a 50 é: " + resultado);
    }

    public static int somar(int inicio, int fim) {
        if (inicio == fim) {
            return fim;
        } else {
            return inicio + somar(inicio + 1, fim);
        }
    }
}






