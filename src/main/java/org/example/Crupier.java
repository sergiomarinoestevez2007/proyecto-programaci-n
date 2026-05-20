package org.example;

public class Crupier extends Participante{

    public Crupier() {
        super();
    }


    public void jugarTurno(Baraja baraja) {
        // El crupier pide cartas mientras tenga menos de 17
        while (mano.calcularValor() < 17) {
            Carta carta = baraja.repartirCarta();
            mano.agregarCarta(carta);
        }
    }
}
