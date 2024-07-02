/*import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public class TGrafoDirigidoTest {

    private TGrafoDirigido grafo;

    @BeforeEach
    public void setUp() {
        grafo = new TGrafoDirigido();
    }

    @Test
    public void testOrdenParcial() {
        try {
            grafo.cargarTareasDesdeArchivo("tareas.txt");
            grafo.cargarPrecedenciasDesdeArchivo("precedencias.txt");

            LinkedList<TVertice> orden = grafo.ordenParcial();

            // Verificar que el tamaño del orden obtenido sea el esperado
            Assertions.assertEquals(3, orden.size());

            // Verificar el orden específico según el ejemplo
            Assertions.assertEquals("A", orden.get(0).getEtiqueta());
            Assertions.assertEquals("B", orden.get(1).getEtiqueta());
            Assertions.assertEquals("Fin", orden.get(2).getEtiqueta());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Assertions.fail("Error en carga de archivos");
        }
    }
}

*/