package com.example.ut8;

import java.util.*;

public class TGrafoDirigido {

    private Map<String, TVertice> vertices;

    public TGrafoDirigido() {
        vertices = new HashMap<>();
    }

    public boolean insertarVertice(String etiqueta) {
        if (!vertices.containsKey(etiqueta)) {
            TVertice vertice = new TVertice(etiqueta);
            vertices.put(etiqueta, vertice);
            return true;
        }
        return false;
    }

    public boolean insertarArista(String etiquetaOrigen, String etiquetaDestino, double costo) {
        TVertice origen = vertices.get(etiquetaOrigen);
        TVertice destino = vertices.get(etiquetaDestino);

        if (origen != null && destino != null) {
            TAdyacencia adyacencia = new TAdyacencia(costo, destino);
            origen.agregarAdyacencia(adyacencia);
            return true;
        }
        return false;
    }

    public void dfs() {
        for (TVertice vertice : vertices.values()) {
            vertice.setVisitado(false);
        }

        int tiempo = 0;
        for (TVertice vertice : vertices.values()) {
            if (!vertice.esVisitado()) {
                dfsRecursivo(vertice, tiempo);
            }
        }
    }

    private void dfsRecursivo(TVertice vertice, int tiempo) {
        vertice.setVisitado(true);
        vertice.setTiempoDescubrimiento(++tiempo);

        for (TAdyacencia adyacencia : vertice.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.esVisitado()) {
                dfsRecursivo(destino, tiempo);
            }
        }

        vertice.setTiempoFinalizacion(++tiempo);
    }

    // Método para clasificar todos los arcos del grafo
    public void clasificarArcos(LinkedList<TAdyacencia> arcosArbol, LinkedList<TAdyacencia> arcosRetroceso,
                                LinkedList<TAdyacencia> arcosAvance, LinkedList<TAdyacencia> arcosCruzados) {
        for (TVertice vertice : vertices.values()) {
            vertice.clasificarArcos(arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);
        }
    }

    public static void main(String[] args) {
        TGrafoDirigido grafo = new TGrafoDirigido();

        // Ejemplo de grafo simple
        grafo.insertarVertice("A");
        grafo.insertarVertice("B");
        grafo.insertarVertice("C");
        grafo.insertarVertice("D");

        grafo.insertarArista("A", "B", 0.0);
        grafo.insertarArista("A", "C", 0.0);
        grafo.insertarArista("B", "C", 0.0);
        grafo.insertarArista("C", "D", 0.0);

        // Realizar DFS para establecer tiempos de descubrimiento y finalización
        grafo.dfs();

        // Clasificar los arcos del grafo
        LinkedList<TAdyacencia> arcosArbol = new LinkedList<>();
        LinkedList<TAdyacencia> arcosRetroceso = new LinkedList<>();
        LinkedList<TAdyacencia> arcosAvance = new LinkedList<>();
        LinkedList<TAdyacencia> arcosCruzados = new LinkedList<>();

        grafo.clasificarArcos(arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);

        // Imprimir los arcos clasificados
        System.out.println("Arcos de Árbol:");
        for (TAdyacencia arco : arcosArbol) {
            System.out.println(arco.getDestino().getEtiqueta());
        }

        System.out.println("\nArcos de Retroceso:");
        for (TAdyacencia arco : arcosRetroceso) {
            System.out.println(arco.getDestino().getEtiqueta());
        }

        System.out.println("\nArcos de Avance:");
        for (TAdyacencia arco : arcosAvance) {
            System.out.println(arco.getDestino().getEtiqueta());
        }

        System.out.println("\nArcos Cruzados:");
        for (TAdyacencia arco : arcosCruzados) {
            System.out.println(arco.getDestino().getEtiqueta());
        }
    }
}

