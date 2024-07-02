package com.example.pd2;

import java.util.*;

public class TGrafoDirigido implements IGrafoDirigido {
    private Map<Comparable, TVertice> vertices;

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice);
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    @Override
    public Comparable centroDelGrafo() {
        // Implementación del método centroDelGrafo
        // Debes retornar la etiqueta del centro del grafo
        // Aquí deberías implementar tu lógica específica para encontrar el centro del grafo
        return null; // Implementa la lógica adecuada aquí
    }

    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        // Implementación del método eliminarArista
        TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
        if (vertOrigen != null) {
            return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
        }
        return false;
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        // Implementación del método eliminarVertice
        TVertice vert = buscarVertice(nombreVertice);
        if (vert != null) {
            vertices.remove(nombreVertice);
            for (TVertice v : vertices.values()) {
                v.eliminarAdyacencia(nombreVertice);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        // Implementación del método existeArista
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        return (vertOrigen != null && vertDestino != null) && vertOrigen.buscarAdyacencia(vertDestino) != null;
    }

    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        // Implementación del método existeVertice
        return vertices.containsKey(unaEtiqueta);
    }

    @Override
    public Double[][] floyd() {
        // Implementación del método floyd
        // Debes implementar el algoritmo de Floyd-Warshall para encontrar los caminos mínimos
        // entre todos los pares de vértices
        return null; // Implementa la lógica adecuada aquí
    }

    @Override
    public boolean insertarArista(TArista arista) {
        // Implementación del método insertarArista
        TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
        TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
        return (vertOrigen != null && vertDestino != null) && vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
    }

    @Override
    public boolean insertarVertice(TVertice vertice) {
        // Implementación del método insertarVertice
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if (unaEtiqueta != null && !existeVertice(unaEtiqueta)) {
            vertices.put(unaEtiqueta, vertice);
            return true;
        }
        return false;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        // Implementación del método obtenerExcentricidad
        // Debes implementar la lógica para calcular la excentricidad del vértice con la etiqueta dada
        return null; // Implementa la lógica adecuada aquí
    }

    @Override
    public boolean[][] warshall() {
        // Implementación del método warshall
        // Debes implementar el algoritmo de Warshall para encontrar la cerradura transitiva del grafo
        return null; // Implementa la lógica adecuada aquí
    }

    @Override
    public Map<Comparable, TVertice> getVertices() {
        // Implementación del método getVertices
        // Debes retornar el mapa de vértices
        return vertices;
    }

    // Otros métodos auxiliares que puedas tener en TGrafoDirigido

    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return vertices.get(unaEtiqueta);
    }
}
