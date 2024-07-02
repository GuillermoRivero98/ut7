/*package com.example.pd2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class TGrafoDirigidoTest {

    private TGrafoDirigido grafo;

    @BeforeEach
    public void setUp() {
        // Crear un grafo para usar en las pruebas
        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(new TVertice("A"));
        vertices.add(new TVertice("B"));
        vertices.add(new TVertice("C"));

        Collection<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 5.0));
        aristas.add(new TArista("B", "C", 10.0));

        grafo = new TGrafoDirigido(vertices, aristas);
    }

    @Test
    public void testExisteVertice() {
        Assertions.assertTrue(grafo.existeVertice("A"));
        Assertions.assertFalse(grafo.existeVertice("D"));
    }

    @Test
    public void testInsertarVertice() {
        TVertice nuevoVertice = new TVertice("D");
        Assertions.assertTrue(grafo.insertarVertice(nuevoVertice));
        Assertions.assertTrue(grafo.existeVertice("D"));
    }

    @Test
    public void testEliminarVertice() {
        Assertions.assertTrue(grafo.eliminarVertice("A"));
        Assertions.assertFalse(grafo.existeVertice("A"));
    }

    @Test
    public void testExisteArista() {
        Assertions.assertTrue(grafo.existeArista("A", "B"));
        Assertions.assertFalse(grafo.existeArista("A", "C"));
    }

    @Test
    public void testInsertarArista() {
        TArista nuevaArista = new TArista("A", "C", 7.0);
        Assertions.assertTrue(grafo.insertarArista(nuevaArista));
        Assertions.assertTrue(grafo.existeArista("A", "C"));
    }

    @Test
    public void testEliminarArista() {
        Assertions.assertTrue(grafo.eliminarArista("B", "C"));
        Assertions.assertFalse(grafo.existeArista("B", "C"));
    }

    @Test
    public void testFloyd() {
        Double[][] distancias = grafo.floyd();
        // Verifica que la matriz de distancias no sea nula y tiene las dimensiones esperadas
        Assertions.assertNotNull(distancias);
        Assertions.assertEquals(3, distancias.length);
        Assertions.assertEquals(3, distancias[0].length);
        // Verifica algunos valores esperados
        Assertions.assertEquals(0.0, distancias[0][0]); // Distancia de un vértice a sí mismo
        Assertions.assertEquals(5.0, distancias[0][1]); // Distancia A a B
        Assertions.assertEquals(15.0, distancias[0][2]); // Distancia A a C
    }

    @Test
    public void testObtenerExcentricidad() {
        Comparable excentricidad = grafo.obtenerExcentricidad("A");
        // Verifica el valor esperado de la excentricidad
        Assertions.assertEquals(15.0, excentricidad);
    }

    @Test
    public void testWarshall() {
        boolean[][] alcanzables = grafo.warshall();
        // Verifica que la matriz de alcanzabilidad no sea nula y tiene las dimensiones esperadas
        Assertions.assertNotNull(alcanzables);
        Assertions.assertEquals(3, alcanzables.length);
        Assertions.assertEquals(3, alcanzables[0].length);
        // Verifica algunos valores esperados
        Assertions.assertTrue(alcanzables[0][0]); // A debe ser alcanzable desde sí mismo
        Assertions.assertTrue(alcanzables[0][1]); // A debe ser alcanzable desde B
        Assertions.assertFalse(alcanzables[0][2]); // A no debe ser alcanzable desde C
    }
}
*/