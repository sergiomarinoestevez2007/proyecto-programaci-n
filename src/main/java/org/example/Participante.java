package org.example;

public abstract class Participante {

    protected Mano mano;

    public Participante() {
        this.mano = new Mano();
    }

    public Mano getMano() {
        return mano;
    }

    public void reiniciarMano() {
        this.mano = new Mano();
    }

    public void pedirCarta(Baraja baraja) {
        mano.agregarCarta(baraja.repartirCarta());
    }
}



