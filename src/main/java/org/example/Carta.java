package org.example;

import java.util.HashMap;
import java.util.Map;

public class Carta {
    private String palo;
    private String valor;
    private static final Map<String, Integer> cartas = new HashMap<>();
    static {
        cartas.put("A", 11);
        cartas.put("2", 2);
        cartas.put("3", 3);
        cartas.put("4", 4);
        cartas.put("5", 5);
        cartas.put("6", 6);
        cartas.put("7", 7);
        cartas.put("8", 8);
        cartas.put("9", 9);
        cartas.put("10", 10);
        cartas.put("J", 10);
        cartas.put("Q", 10);
        cartas.put("K", 10);
    }
    public Carta(String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }
    public String getPalo() {
        return palo;
    }
    public String getValor() {
        return valor;
    }
    public int getValorNumerico() {
        return cartas.get(valor);
    }
    @Override
    public String toString() {
        // Esto es lo que se verá en la consola
        return valor + " de " + palo;
    }
}
