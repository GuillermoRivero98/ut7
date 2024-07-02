package com.example.ut8;

import java.util.LinkedList;

public class TVertice {

    private String etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private int tiempoDescubrimiento; // Tiempo de descubrimiento en la búsqueda en profundidad
    private int tiempoFinalizacion;   // Tiempo de finalización en la búsqueda en profundidad
    private boolean visitado;

    public TVertice(String etiqueta) {
        this.etiqueta = etiqueta;
        adyacentes = new LinkedList<>();
        visitado = false;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public void agregarAdyacencia(TAdyacencia adyacencia) {
        adyacentes.add(adyacencia);
    }

    public boolean esVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public int getTiempoDescubrimiento() {
        return tiempoDescubrimiento;
    }

    public void setTiempoDescubrimiento(int tiempoDescubrimiento) {
        this.tiempoDescubrimiento = tiempoDescubrimiento;
    }

    public int getTiempoFinalizacion() {
        return tiempoFinalizacion;
    }

    public void setTiempoFinalizacion(int tiempoFinalizacion) {
        this.tiempoFinalizacion = tiempoFinalizacion;
    }

    // Método para clasificar los arcos
    public void clasificarArcos(LinkedList<TAdyacencia> arcosArbol, LinkedList<TAdyacencia> arcosRetroceso,
                                LinkedList<TAdyacencia> arcosAvance, LinkedList<TAdyacencia> arcosCruzados) {
        for (TAdyacencia adyacencia : adyacentes) {
            TVertice destino = adyacencia.getDestino();

            // Clasificación según los tiempos de descubrimiento y finalización
            if (destino.getTiempoDescubrimiento() > this.tiempoDescubrimiento &&
                destino.getTiempoFinalizacion() > this.tiempoFinalizacion) {
                arcosArbol.add(adyacencia); // Arco de árbol
            } else if (destino.getTiempoDescubrimiento() < this.tiempoDescubrimiento &&
                       destino.getTiempoFinalizacion() > this.tiempoFinalizacion) {
                arcosAvance.add(adyacencia); // Arco de avance
            } else if (destino.getTiempoDescubrimiento() > this.tiempoDescubrimiento &&
                       destino.getTiempoFinalizacion() < this.tiempoFinalizacion) {
                arcosRetroceso.add(adyacencia); // Arco de retroceso
            } else {
                arcosCruzados.add(adyacencia); // Arco cruzado
            }
        }
    }
}

