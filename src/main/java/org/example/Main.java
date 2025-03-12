package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<CabinaTelefonica> lstcabinas = new ArrayList<>();
        int a = 0;
        do {
            System.out.println("\n***********************************************");
            System.out.println("* Sistema de Control de Gastos Telefónicos    *");
            System.out.println("* 1. Crear cabina telefónica                  *");
            System.out.println("* 2. Registrar una llamada                    *");
            System.out.println("* 3. Mostrar información de una cabina        *");
            System.out.println("* 4. Mostrar consolidado de todas las cabinas *");
            System.out.println("* 5. Reiniciar las cabinas                    *");
            System.out.println("* 6. Salir                                    *");
            System.out.println("***********************************************");
            System.out.print("Seleccione una opción: ");
            a = teclado.nextInt();
            switch (a){
                case 1:
                    CabinaTelefonica nuevaCabina = new CabinaTelefonica();
                    lstcabinas.add(nuevaCabina);
                    System.out.println("Cabina telefónica creada con éxito. ID: " + nuevaCabina.getId());
                    break;

                case 2:
                    System.out.print("Seleccione el ID de la cabina: ");
                    int idCabina = teclado.nextInt();
                    if (idCabina > 0 && idCabina <= lstcabinas.size()) {
                        System.out.println("Seleccione el tipo de llamada: ");
                        System.out.println("1. Llamada Local");
                        System.out.println("2. Llamada Larga Distancia");
                        System.out.println("3. Llamada Celular");
                        int tipo = teclado.nextInt();
                        lstcabinas.get(idCabina - 1).registrarLlamada(tipo);
                    } else {
                        System.out.println("ID de cabina no válido.");
                    }
                    break;

                case 3:
                    System.out.print("Seleccione el ID de la cabina: ");
                    idCabina = teclado.nextInt();
                    if (idCabina > 0 && idCabina <= lstcabinas.size()) {
                        lstcabinas.get(idCabina - 1).mostrarInformacion();
                    } else {
                        System.out.println("ID de cabina no válido.");
                    }
                    break;

                case 4:
                    int totalLlamadas = 0;
                    int totalMinutos = 0;
                    int totalCosto = 0;

                    for (CabinaTelefonica cabina : lstcabinas) {
                        totalLlamadas += cabina.getLlamadaLocal() + cabina.getLlamadaLargaDistancia() + cabina.getLlamadaCelular();
                        totalMinutos += cabina.getMinutoLocal() + cabina.getMinutoLargaDistancia() + cabina.getMinutoCelulare();
                        totalCosto += cabina.calcularCostoTotal();
                    }

                    System.out.println("Consolidado Total:");
                    System.out.println("Total de Llamadas: " + totalLlamadas);
                    System.out.println("Total de Minutos: " + totalMinutos);
                    System.out.println("Total Costo: " + totalCosto + " pesos");
                    break;

                case 5:
                    for (CabinaTelefonica cabina : lstcabinas) {
                        cabina.reiniciar();
                    }
                    System.out.println("Todas las cabinas han sido reiniciadas.");
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("La opción seleccionada no es válida.");
            }

        } while (a != 6);

        System.out.println("La opcion que deseas seleccionar no se encuentra registrada en nuestro sistema");
    }
}
/*Se quiere crear una aplicación para controlar los gastos telefónicos de una empresa.
La empresa cuenta con N cabinas telefónicas a través de las cuales se pueden realizar
llamadas locales, de larga distancia y a celulares.
La empresa cuenta con planes telefónicos que establecen las siguientes tarifas:
Minuto Llamada Local: $50 pesos
Minuto Llamada Larga Distancia: $350 pesos
Minuto Llamada Celular: $150 pesos
La aplicación debe permitir:
1. Crear cabina telefónica
2. Escoger cabina telefonica - Registrar una llamada de acuerdo con la cabina (local,
   larga distancia, celular )
3. Mostrar la información detallada por cabina (número de llamadas realizadas, duración
   total de las llamadas en minutos y el costo total de las llamadas en pesos)
4. Mostrar un consolidado total de toda la información de las cabinas (costo total en
   pesos de la cabina, número total de llamadas realizadas, duración total de llamadas en
   minutos).
Adicionalmente, la aplicación debe permitir reiniciar el uso de la cabina telefónica,
dejando todos sus valores en cero.*/