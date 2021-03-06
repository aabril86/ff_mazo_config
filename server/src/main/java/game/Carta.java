package main.java.game;


import main.java.Mensaje;

public class Carta {
    String nombre;
    String descripcion;
    String tipo;
    int valor;
    int coste_cristal;

    public Carta(String nombre, int valor, int coste, String tipo) {
        this.nombre = nombre;
        this.valor = valor;
        this.coste_cristal = coste;
        this.tipo = tipo;
    }

    public Carta(Mensaje.Carta carta){
        this.nombre = carta.nombre;
        this.valor = carta.valor;
    }

    Mensaje.Carta toMensaje(){
        return new Mensaje.Carta(nombre, valor);
    }
}
