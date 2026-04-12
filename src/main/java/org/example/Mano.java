package org.example;
import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public int calcularValor() {
        int total = 0;
        int ases = 0;

        for (Carta c : cartas) {
            total += c.getValorNumerico();
            if (c.getValor().equals("A")) {
                ases++;
            }
        }

        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }

        return total;
    }

    public boolean tieneBlackjack() {
        return cartas.size() == 2 && calcularValor() == 21;
    }

    public boolean estaBust() {
        return calcularValor() > 21;
    }

    public List<Carta> getCartas() {
        return cartas;
    }
}
