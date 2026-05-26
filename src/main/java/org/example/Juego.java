package org.example;
import java.util.ArrayList;
import java.util.List;


public class Juego {
    private Jugador jugador;
    private Crupier crupier;
    private Baraja baraja;
    private List<Participante> participantes;

    public Juego(Jugador jugador) {
        this.jugador = jugador;
        this.crupier = new Crupier();
        participantes = new ArrayList<>();
        participantes.add(jugador);
        participantes.add(crupier);
    }

    public void iniciarRonda() {
        baraja = new Baraja();
        baraja.barajar();
        for (Participante p : participantes) {
            p.reiniciarMano();
        }
    }

    public void repartirInicial() {
        jugador.pedirCarta(baraja);
        jugador.pedirCarta(baraja);

        crupier.getMano().agregarCarta(baraja.repartirCarta());
        crupier.getMano().agregarCarta(baraja.repartirCarta());
    }

    public String determinarGanador() {
        int valorJugador = jugador.getMano().calcularValor();
        int valorCrupier = crupier.getMano().calcularValor();
        int apuesta = jugador.getApuesta().getCantidad();

        if (jugador.getMano().estaBust()) {
            return "Te has pasado de 21. ¡Gana el Crupier!";
        } else if (crupier.getMano().estaBust()) {
            jugador.setCreditos(jugador.getCreditos() + (apuesta * 2));
            return "El Crupier se ha pasado. ¡Has ganado!";
        } else if (valorJugador > valorCrupier) {
            jugador.setCreditos(jugador.getCreditos() + (apuesta * 2));
            return "¡Tienes mejor puntuación! Has ganado.";
        } else if (valorCrupier > valorJugador) {
            return "El Crupier tiene mejor puntuación. ¡Gana el Crupier!";
        } else {
            jugador.setCreditos(jugador.getCreditos() + apuesta);
            return "¡Empate! Se devuelve tu apuesta.";
        }
    }

    public Baraja getBaraja() {
        return baraja;
    }

    public Crupier getCrupier() {
        return crupier;
    }
}
