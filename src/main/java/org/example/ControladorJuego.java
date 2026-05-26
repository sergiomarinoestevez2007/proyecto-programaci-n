package org.example;

public class ControladorJuego {
    private Juego juego;
    private VistaJuego vista;

    public ControladorJuego() {
        this.vista = new VistaJuego();
    }

    public void jugar() throws Exception {
        Jugador jugador = new Jugador("Jugador 1", 1000);
        juego = new Juego(jugador);

        vista.mostrarMensaje("¡Bienvenido al Casino Blackjack!");

        while (jugador.getCreditos() > 0) {
            int cantidadApuesta = vista.pedirApuesta(jugador.getCreditos());

            jugador.realizarApuesta(cantidadApuesta);
            juego.iniciarRonda();
            juego.repartirInicial();

            boolean plantado = false;
            boolean turnoTerminado = false;

            // Turno del Jugador
            while (!jugador.getMano().estaBust() && !plantado && !turnoTerminado) {
                vista.mostrarManos(jugador, juego.getCrupier(), false);

                if (jugador.getMano().tieneBlackjack()) {
                    vista.mostrarMensaje("¡BLACKJACK!");
                    turnoTerminado = true;
                    continue;
                }

                String accion = vista.pedirAccion();

                switch (accion) {
                    case "1":
                        jugador.pedirCarta(juego.getBaraja());
                        break;
                    case "2":
                        plantado = true;
                        break;
                    case "3":
                        if (jugador.getCreditos() >= jugador.getApuesta().getCantidad()) {
                            jugador.doblar();
                            jugador.pedirCarta(juego.getBaraja());
                            turnoTerminado = true; // Solo una carta al doblar
                        } else {
                            vista.mostrarMensaje("No tienes créditos suficientes para doblar.");
                        }
                        break;
                    default:
                        vista.mostrarMensaje("Opción incorrecta.");
                        break;
                }
            }

            // Turno del Crupier
            if (!jugador.getMano().estaBust()) {
                vista.mostrarMensaje("\nTurno del Crupier...");
                juego.getCrupier().jugarTurno(juego.getBaraja());
            }

            // Fin de la ronda
            vista.mostrarManos(jugador, juego.getCrupier(), true);
            String resultado = juego.determinarGanador();
            vista.mostrarMensaje("\n" + resultado);
            vista.mostrarMensaje("----------------------------------------\n");

            if (jugador.getCreditos() <= 0) {
                vista.mostrarMensaje("Te has quedado sin créditos. ¡Fin del Juego!");
            }
        }
    }
}
