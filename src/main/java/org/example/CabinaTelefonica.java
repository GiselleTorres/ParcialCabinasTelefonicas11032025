package org.example;

import java.util.Random;

public class CabinaTelefonica {
    private static int idCabina = 1;
    private int id;
    private int llamadaLocal;
    private int llamadaLargaDistancia;
    private int llamadaCelular;
    private int minutoLocal;
    private int minutoLargaDistancia;
    private int minutoCelular;
    //Static final lo utilizo para declarar las variables de la clase global y que su valor
    //no pueda ser modificado despues
    private static final int TarifaLocal = 50;
    private static final int TarifaLargaDistancia = 350;
    private static final int TarifaCelular = 150;

    public CabinaTelefonica() {
        this.id = idCabina++;
    }

    public CabinaTelefonica(int llamadaLocal, int llamadaLargaDistancia, int llamadaCelular, int id, int minutoLocal, int minutoLargaDistancia, int minutoCelulare) {
        this.llamadaLocal = llamadaLocal;
        this.llamadaLargaDistancia = llamadaLargaDistancia;
        this.llamadaCelular = llamadaCelular;
        this.id = id;
        this.minutoLocal = minutoLocal;
        this.minutoLargaDistancia = minutoLargaDistancia;
        this.minutoCelular = minutoCelulare;
    }

    public static int getIdCounter() {
        return idCabina;
    }

    public static void setIdCounter(int idCounter) {
        CabinaTelefonica.idCabina = idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLlamadaLocal() {
        return llamadaLocal;
    }

    public void setLlamadaLocal(int llamadaLocal) {
        this.llamadaLocal = llamadaLocal;
    }

    public int getLlamadaLargaDistancia() {
        return llamadaLargaDistancia;
    }

    public void setLlamadaLargaDistancia(int llamadaLargaDistancia) {
        this.llamadaLargaDistancia = llamadaLargaDistancia;
    }

    public int getLlamadaCelular() {
        return llamadaCelular;
    }

    public void setLlamadaCelular(int llamadaCelular) {
        this.llamadaCelular = llamadaCelular;
    }

    public int getMinutoLocal() {
        return minutoLocal;
    }

    public void setMinutoLocal(int minutoLocal) {
        this.minutoLocal = minutoLocal;
    }

    public int getMinutoLargaDistancia() {
        return minutoLargaDistancia;
    }

    public void setMinutoLargaDistancia(int minutoLargaDistancia) {
        this.minutoLargaDistancia = minutoLargaDistancia;
    }

    public int getMinutoCelulare() {
        return minutoCelular;
    }

    public void setMinutoCelulare(int minutoCelulare) {
        this.minutoCelular = minutoCelulare;
    }

    @Override
    public String toString() {
        return "CabinaTelefonica{" +
                "id=" + id +
                ", llamadaLocal=" + llamadaLocal +
                ", llamadaLargaDistancia=" + llamadaLargaDistancia +
                ", llamadaCelular=" + llamadaCelular +
                ", minutoLocal=" + minutoLocal +
                ", minutoLargaDistancia=" + minutoLargaDistancia +
                ", minutoCelulare=" + minutoCelular +
                '}';
    }

    public void registrarLlamada(int tipo) {
        Random rand = new Random();
        int minutos = rand.nextInt(180) + 1;
        switch (tipo) {
            case 1:
                llamadaLocal++;
                minutoLocal += minutos;
                break;
            case 2:
                llamadaLargaDistancia++;
                minutoLargaDistancia += minutos;
                break;
            case 3:
                llamadaCelular++;
                minutoCelular += minutos;
                break;
            default:
                System.out.println("Tipo de llamada no válido.");
                return;
        }

            System.out.println("Llamada registrada: Tipo " + tipo + ", Duración: " + minutos + " minutos.");
    }

    public int calcularCostoTotal() {
        return (minutoLocal * TarifaLocal) + (minutoLargaDistancia * TarifaLargaDistancia) + (minutoCelular * TarifaCelular);
    }

    public void mostrarInformacion() {
        System.out.println("Cabina " + id);
        System.out.println("Llamadas Locales: " + llamadaLocal + ", Minutos: " + minutoLocal + ", Costo: " + (minutoLocal * TarifaLocal));
        System.out.println("Llamadas Larga Distancia: " + llamadaLargaDistancia + ", Minutos: " + minutoLargaDistancia + ", Costo: " + (minutoLargaDistancia * TarifaLargaDistancia));
        System.out.println("Llamadas a Celular: " + llamadaCelular + ", Minutos: " + minutoCelular + ", Costo: " + (minutoCelular * TarifaCelular));
        System.out.println("Costo Total: " + calcularCostoTotal() + " pesos");
    }

    public void reiniciar() {
        llamadaLocal = 0;
        llamadaLargaDistancia = 0;
        llamadaCelular = 0;
        minutoLocal = 0;
        minutoLargaDistancia = 0;
        minutoCelular = 0;
    }
}
