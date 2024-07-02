package com.example.pd7;

import java.util.LinkedList;

public class TVertice {

    private String etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;

    public TVertice(String etiqueta) {
        this.etiqueta = etiqueta;
        adyacentes = new LinkedList<>();
        visitado = false;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public void agregarAdyacencia(TAdyacencia adyacencia) {
        adyacentes.add(adyacencia);
    }

    public boolean esVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
}

