package com.example.pd4;

public class Main {

    public static void main(String[] args) {
        // Cargar el grafo desde archivos
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo(
                "./src/aeropuertos_1.txt", "./src/conexiones_1.txt", false, TGrafoDirigido.class);

        // Mostrar las etiquetas de los vértices ordenadas
        Object[] etiquetasOrdenadas = gd.getEtiquetasOrdenado();
        System.out.println("Etiquetas de los vértices ordenadas:");
        for (Object etiqueta : etiquetasOrdenadas) {
            System.out.print(etiqueta + " ");
        }
        System.out.println("\n");

        // Encontrar todos los caminos desde "Santos" a "Curitiba"
        Comparable origen = "Santos";
        Comparable destino = "Curitiba";

        TCaminos caminos = gd.todosLosCaminos(origen, destino);

        if (caminos != null) {
            System.out.println("Todos los caminos desde " + origen + " hasta " + destino + ":");
            caminos.imprimirCaminosConsola();
        } else {
            System.out.println("No se encontraron caminos desde " + origen + " hasta " + destino);
        }
    }
}
