package com.example.ut8;

import java.util.LinkedList;

public class main {
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
