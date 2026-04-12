package org.example;
import java.util.Scanner;

public class VistaJuego {
    private Scanner scanner;

    public VistaJuego() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int pedirApuesta(int creditosActuales) {
        System.out.print("Tienes " + creditosActuales + " créditos. Ingresa tu apuesta: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido.");
            scanner.next();
        }
        int apuesta = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return apuesta;
    }

    public String pedirAccion() {
        System.out.println("\n¿Qué deseas hacer?");
        System.out.println("1. Pedir carta");
        System.out.println("2. Plantarse");
        System.out.println("3. Doblar");
        System.out.print("Elige opción: ");
        return scanner.nextLine();
    }

    public void mostrarManos(Jugador jugador, Crupier crupier, boolean finRonda) {
        System.out.println("\n=== ESTADO DE LA MESA ===");
        System.out.println("Tú mano: " + jugador.getMano().getCartas() + " (Valor: " + jugador.getMano().calcularValor() + ")");

        if (finRonda) {
            System.out.println("Crupier: " + crupier.getMano().getCartas() + " (Valor: " + crupier.getMano().calcularValor() + ")");
        } else {
            System.out.println("Crupier: [" + crupier.getMano().getCartas().get(0) + ", [CARTA OCULTA]]");
        }
        System.out.println("=========================");
    }
}
