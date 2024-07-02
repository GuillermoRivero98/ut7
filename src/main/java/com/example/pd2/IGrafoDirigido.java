package com.example.pd2;

import java.util.Map;

public interface IGrafoDirigido {

    Comparable centroDelGrafo();

    boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino);

    boolean eliminarVertice(Comparable nombreVertice);

    boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino);

    boolean existeVertice(Comparable unaEtiqueta);

    Double[][] floyd();

    boolean insertarArista(TArista arista);

    boolean insertarVertice(TVertice vertice);

    Comparable obtenerExcentricidad(Comparable etiquetaVertice);

    boolean[][] warshall();

    Map<Comparable, TVertice> getVertices(); // Nuevo método para obtener los vértices del grafo
}
