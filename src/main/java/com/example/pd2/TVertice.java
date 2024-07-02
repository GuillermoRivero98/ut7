package com.example.pd2;

import java.util.LinkedList;

public class TVertice<T> implements IVertice {
    private final Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        this.adyacentes = new LinkedList<>();
        this.visitado = false;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    public T getDatos() {
        return datos;
    }

    public void setDatos(T datos) {
        this.datos = datos;
    }

    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            adyacentes.add(ady);
            return true;
        }
        return false;
    }

    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    public void bpf(LinkedList<TVertice> visitados) {
        this.setVisitado(true);
        visitados.add(this);
        for (TAdyacencia ady : this.getAdyacentes()) {
            if (!ady.getDestino().getVisitado()) {
                ady.getDestino().bpf(visitados);
            }
        }
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia adyacencia = buscarAdyacencia(verticeDestino);
        return adyacencia != null ? adyacencia.getCosto() : Double.MAX_VALUE;
    }

    @Override
    public TVertice primerAdyacente() {
        return adyacentes.isEmpty() ? null : adyacentes.getFirst().getDestino();
    }

    @Override
    public TVertice siguienteAdyacente(TVertice verticeDestino) {
        boolean found = false;
        for (TAdyacencia ady : adyacentes) {
            if (found) {
                return ady.getDestino();
            }
            if (ady.getDestino().equals(verticeDestino)) {
                found = true;
            }
        }
        return null;
    }
}
