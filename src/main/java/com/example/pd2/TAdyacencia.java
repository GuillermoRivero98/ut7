package com.example.pd2;
public class TAdyacencia implements IAdyacencia {
    private double costo;
    private TVertice destino;

    public TAdyacencia(double costo, TVertice destino) {
        this.costo = costo;
        this.destino = destino;
    }

    @Override
    public double getCosto() {
        return costo;
    }

    @Override
    public TVertice getDestino() {
        return destino;
    }

    @Override
    public Comparable getEtiqueta() {
        return destino.getEtiqueta();
    }
}
