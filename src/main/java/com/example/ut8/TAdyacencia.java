package com.example.ut8;

public class TAdyacencia {

    private double costo;
    private TVertice destino;

    public TAdyacencia(double costo, TVertice destino) {
        this.costo = costo;
        this.destino = destino;
    }

    public double getCosto() {
        return costo;
    }

    public TVertice getDestino() {
        return destino;
    }
}

