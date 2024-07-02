package com.example.pd5;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TGrafoDirigido<T> {

    private Map<Comparable, TVertice<T>> vertices;

    public TGrafoDirigido() {
        vertices = new HashMap<>();
    }

    public boolean insertarVertice(Comparable etiqueta) {
        if (!vertices.containsKey(etiqueta)) {
            TVertice<T> vertice = new TVertice<>(etiqueta);
            vertices.put(etiqueta, vertice);
            return true;
        }
        return false;
    }

    public boolean eliminarVertice(Comparable etiqueta) {
        TVertice<T> vertice = vertices.remove(etiqueta);
        if (vertice != null) {
            // Eliminar todas las adyacencias hacia este vértice
            for (TVertice<T> v : vertices.values()) {
                v.eliminarAdyacencia(etiqueta);
            }
            return true;
        }
        return false;
    }

    public boolean insertarArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, Double costo) {
        TVertice<T> origen = vertices.get(etiquetaOrigen);
        TVertice<T> destino = vertices.get(etiquetaDestino);

        if (origen != null && destino != null) {
            return origen.insertarAdyacencia(costo, destino);
        }
        return false;
    }

    public boolean eliminarArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice<T> origen = vertices.get(etiquetaOrigen);
        if (origen != null) {
            return origen.eliminarAdyacencia(etiquetaDestino);
        }
        return false;
    }

    public boolean esVertice(Comparable etiqueta) {
        return vertices.containsKey(etiqueta);
    }

    public boolean esArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice<T> origen = vertices.get(etiquetaOrigen);
        if (origen != null) {
            return origen.buscarAdyacencia(etiquetaDestino) != null;
        }
        return false;
    }

    public Collection<TVertice<T>> obtenerVertices() {
        return vertices.values();
    }

    public int cantidadVertices() {
        return vertices.size();
    }

    public int cantidadAristas() {
        int count = 0;
        for (TVertice<T> v : vertices.values()) {
            count += v.getAdyacentes().size();
        }
        return count;
    }

    // Otros métodos según necesidades adicionales...

}
