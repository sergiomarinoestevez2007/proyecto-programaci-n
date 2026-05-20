package org.example;

public class Jugador extends Participante implements AccionesJuego{
    private String nombre;
    private int creditos;
    private Apuesta apuesta;

    public Jugador(String nombre, int creditos, Apuesta apuesta) {
        super();
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public void pedirCarta(Baraja baraja) {
        mano.agregarCarta(baraja.repartirCarta());
    }

    public void plantarse() {
        
    }
    
    public void doblar() {
        if (apuesta != null && creditos >= apuesta.getCantidad()) {
            creditos -= apuesta.getCantidad();
            apuesta = new Apuesta(apuesta.getCantidad() * 2);
        }
    }

    public void dividir() {
        
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void realizarApuesta(int cantidad) {
        this.apuesta = new Apuesta(cantidad);
        this.creditos -= cantidad; // Se descuentan los créditos de inmediato
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public String getNombre() {
        return nombre;
    }
}
