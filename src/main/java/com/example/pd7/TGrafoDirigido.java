package com.example.pd7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public boolean insertarArista(String etiquetaOrigen, String etiquetaDestino, Double costo) {
        TVertice origen = vertices.get(etiquetaOrigen);
        TVertice destino = vertices.get(etiquetaDestino);

        if (origen != null && destino != null) {
            TAdyacencia adyacencia = new TAdyacencia(costo, destino);
            origen.agregarAdyacencia(adyacencia);
            return true;
        }
        return false;
    }

    public LinkedList<TVertice> ordenParcial() {
        LinkedList<TVertice> orden = new LinkedList<>();
        Collection<TVertice> verticesValores = vertices.values();

        for (TVertice vertice : verticesValores) {
            if (!vertice.esVisitado()) {
                ordenParcialRecursivo(vertice, orden);
            }
        }

        return orden;
    }

    private void ordenParcialRecursivo(TVertice vertice, LinkedList<TVertice> orden) {
        vertice.setVisitado(true);

        for (TAdyacencia adyacencia : vertice.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.esVisitado()) {
                ordenParcialRecursivo(destino, orden);
            }
        }

        orden.addFirst(vertice); // Agregar al inicio para mantener el orden topológico correcto
    }

    public void listarTareas(LinkedList<TVertice> orden) {
        for (TVertice vertice : orden) {
            System.out.println(vertice.getEtiqueta());
        }
    }

    public void cargarTareasDesdeArchivo(String archivoTareas) throws FileNotFoundException {
        File file = new File(archivoTareas);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String[] datos = linea.split(",");
            if (datos.length == 2) {
                String codTarea = datos[0].trim();
                String tiempoTarea = datos[1].trim();
                insertarVertice(codTarea);
            }
        }

        scanner.close();
    }

    public void cargarPrecedenciasDesdeArchivo(String archivoPrecedencias) throws FileNotFoundException {
        File file = new File(archivoPrecedencias);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String[] datos = linea.split(",");
            if (datos.length == 2) {
                String codTareaA = datos[0].trim();
                String codTareaB = datos[1].trim();
                insertarArista(codTareaA, codTareaB, 0.0); // Suponemos costo 0 para las precedencias
            }
        }

        scanner.close();
    }

    public void generarArchivoDeOrden(String archivoSalida, LinkedList<TVertice> orden) throws IOException {
        FileWriter writer = new FileWriter(archivoSalida);

        for (TVertice vertice : orden) {
            writer.write(vertice.getEtiqueta() + "\n");
        }

        writer.close();
    }

    public static void main(String[] args) {
        TGrafoDirigido grafo = new TGrafoDirigido();
        LinkedList<TVertice> orden;

        try {
            grafo.cargarTareasDesdeArchivo("tareas.txt");
            grafo.cargarPrecedenciasDesdeArchivo("precedencias.txt");

            orden = grafo.ordenParcial();
            grafo.listarTareas(orden);
            grafo.generarArchivoDeOrden("orden.txt", orden);

            grafo = new TGrafoDirigido(); // Reiniciar para el segundo conjunto de datos
            grafo.cargarTareasDesdeArchivo("tareas.txt");
            grafo.cargarPrecedenciasDesdeArchivo("precedencias2.txt");

            orden = grafo.ordenParcial();
            grafo.listarTareas(orden);
            grafo.generarArchivoDeOrden("orden2.txt", orden);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

