/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mannith
 */
public class Gerente extends Thread {
    private int diasRestantes;
    private int saldo;
    private final int daysDeadline;
    private long dayDurationInMs;
    private long startTime; // Tiempo de inicio
    private int diasTranscurridos;
    private int horasTranscurridas;
    private boolean viendoCarreras; // Estado para indicar si el gerente está viendo carreras

    
    public Gerente(int diasRestantes, int saldo, long dayDurationInMs, int daysDeadline) {
        this.diasRestantes = diasRestantes;
        this.saldo = saldo;
        this.dayDurationInMs = dayDurationInMs;
        this.daysDeadline = daysDeadline;
        this.startTime = System.currentTimeMillis(); // Inicializar el tiempo de inicio
        this.diasTranscurridos = 0;
        this.horasTranscurridas = 0;
        this.viendoCarreras = false; // Inicialmente el gerente no está viendo carreras
    }
    
    public long getDayDurationMs(){
        return dayDurationInMs;
    }
    
    public int getSaldo() {
        return saldo;
    }
    
    public void verCarreras() {
        viendoCarreras = true; // El gerente comienza a ver carreras
        System.out.println("gerente viendo formula");
    }
    
    public void dejarDeVerCarreras() {
        viendoCarreras = false; // El gerente deja de ver carreras
        System.out.println("Gerente Trabajando");
    }
    
    public boolean estaViendoCarreras() {
        return viendoCarreras;
    }

    
    public long getDayDurationInMs() {
        return dayDurationInMs;
    }

    public int getDaysDeadline() {
        return daysDeadline;
    }
    
    public void iniciarNuevoDia() {
        diasTranscurridos++;
        horasTranscurridas = 0;
        startTime = System.currentTimeMillis();
        System.out.println("Quedan: " + diasRestantes + " para la entrega");
    }

    public int obtenerDiasTranscurridos() {
        return diasTranscurridos;
    }

    public int obtenerHorasTranscurridas() {
        long tiempoTranscurrido = obtenerTiempoTranscurrido();
        horasTranscurridas = (int) (tiempoTranscurrido / (1000 * 60 * 60)) % 24; // Horas transcurridas en el día actual
        return horasTranscurridas;
    }
    
    public long obtenerTiempoTranscurrido() {
        long tiempoActual = System.currentTimeMillis();
        return tiempoActual - startTime; // Tiempo transcurrido desde el inicio
    }


    @Override
    public void run() {
//        int dia = obtenerDiasTranscurridos();
        while (diasRestantes > 0) {
            for (int dia = 0; dia <= daysDeadline; dia++) {
                System.out.println("Día " + dia);

                // Ver carreras durante las primeras 16 horas del día
                for (int hora = 0; hora < 16; hora++) {
                    for (int minuto = 0; minuto < 60; minuto += 30) {
                        System.out.println("gerente viendo carreras a las " + hora + ":" + minuto);
                        verCarreras();
                        try {
                            Thread.sleep(dayDurationInMs / (16 * 2)); // Espera la mitad del intervalo de 30 minutos
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dejarDeVerCarreras();
                        System.out.println("gerente deja de ver carreras a las " + hora + ":" + minuto);
                    }
                }

        // Trabajar en la contabilidad durante 8 horas del día
                for (int hora = 16; hora < 24; hora++) {
                    System.out.println("Gerente trabajando en la contabilidad a las " + hora);
                    dejarDeVerCarreras();
                }


                // Actualizar contador de días restantes
                diasRestantes--;
    //            iniciarNuevoDia();
            }
        }
    }
}
