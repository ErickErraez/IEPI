package edu.yavirac.amazonviewer;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    boolean exit = true;
    Scanner sc = new Scanner(System.in);
    
    do {
      System.out.println("\nBIENVENIDOS AMAZON VIEWER");
      System.out.println("1. Movies");
      System.out.println("2. Series");
      System.out.println("3. Books");
      System.out.println("4. Magazines");
      System.out.println("0. Exit");
      System.out.print("Selecciona el numero de la opción deseada: ");

      int entrada = sc.nextInt(); // leer la respuesta del usuario
      
      switch (entrada) {
      case 1:
        System.out.println("Entraste a Movies!");
        break;
      case 2:
        System.out.println("Entraste a Series!");
        break;
      case 3:
        System.out.println("Entraste a Books!");
        break;
      case 4:
        System.out.println("Entraste a Magazines!");
        break;
      case 0:
        System.out.println("Saliste del sistema!");
        exit = false;
        break;
      default:
        System.out.println("Opción no disponible. Intenta de nuevo...");
        break;
      }
    } while (exit);
    sc.close();
  }
}