/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productores;

import classes.VehiclePlant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mannith
 */
public class Gerente extends Thread {
    //private int diasRestantes;
    private double sueldoTotal;
    private double sueldoPorHora;
    //private long dayDurationInMs;
    private long startTime; // Tiempo de inicio
    private int diasTranscurridos;
    private int horasTranscurridas;
    private boolean viendoCarreras; // Estado para indicar si el gerente está viendo carreras
    private VehiclePlant plant;
    private int diasTotales;

    
    public Gerente(VehiclePlant plant, long dayDurationInMs) {
        //this.diasRestantes = diasRestantes;
        //this.dayDurationInMs = dayDurationInMs;
        this.startTime = System.currentTimeMillis(); // Inicializar el tiempo de inicio
        this.diasTranscurridos = 0;
        this.horasTranscurridas = 0;
        this.viendoCarreras = false; // Inicialmente el gerente no está viendo carreras
        this.plant = plant;
        this.sueldoPorHora = 20;
        this.diasTotales = 0;
    }
    
    public long getDayDurationMs(){
        return plant.dayDurationInMs;
    }
    
    public double getSueldoHora(){
        return this.sueldoPorHora;
    }    
    
    public void verCarreras() {
        viendoCarreras = true; // El gerente comienza a ver carreras
//        System.out.println("gerente viendo formula");
    }
    
    public void dejarDeVerCarreras() {
        viendoCarreras = false; // El gerente deja de ver carreras
//        System.out.println("Gerente Trabajando");
    }
    
    public boolean estaViendoCarreras() {
        return viendoCarreras;
    }

    
    public long getDayDurationInMs() {
        return plant.dayDurationInMs;
    }

    public int getDaysDeadline() {
        return plant.daysDeadline;
    }
    
    public void iniciarNuevoDia() {
        diasTranscurridos++;
        horasTranscurridas = 0;
        startTime = System.currentTimeMillis();
        System.out.println("Quedan: " + getDaysDeadline() + " para la entrega");
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
        while (plant.daysDeadline > 0) {
        System.out.println(plant.daysDeadline);

        for (int i = 0; i < 48; i++) { // 48 intervalos de 30 minutos en un día

            if (i < 32) { // Las primeras 16 horas del día
                if (i % 2 == 0) { // Comienzo de una hora
                    if (!estaViendoCarreras()) {
//                        System.out.println("Gerente viendo carreras a las " + (i / 2) + ":00");
                        verCarreras();
                        // set viendo carreras
                        if(plant.isLambo){
                            dashboard.GlobalUI.getMainUI().getLGdashboard1().setGerenteAccion("Viendo carreras");
                        }else{
                            //todo rolls
                        }
                    }
                } else { // Media hora
                    if (estaViendoCarreras()) {
//                        System.out.println("Gerente deja de ver carreras a las " + (i / 2) + ":30");
                        dejarDeVerCarreras();
                        // set revisando contabilidad
                        if(plant.isLambo){
                            dashboard.GlobalUI.getMainUI().getLGdashboard1().setGerenteAccion("Revisando contabilidad");
                        }else{
                            //todo rolls
                        }
                    }
                }
            } else { // El resto del día
                // set cambiando contador
                if(plant.isLambo){
                    dashboard.GlobalUI.getMainUI().getLGdashboard1().setGerenteAccion("Cambiando contador");
                }else{
                    //todo rolls
                }
                if (estaViendoCarreras()) {
//                    System.out.println("Gerente trabajando en la contabilidad a las " + (i / 2));
                    dejarDeVerCarreras();
                }
            }

            try {
                Thread.sleep(plant.dayDurationInMs / 48); // Espera el intervalo de 30 minutos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            // Actualizar contador de días restantes
            plant.daysDeadline--;
            diasTotales++;
            
            if(plant.isLambo){
                dashboard.GlobalUI.getMainUI().getLGdashboard1().setDeadlineLabel(plant.daysDeadline);  // set dias restantes UI
                dashboard.GlobalUI.getMainUI().getLGdashboard1().setDiasTotales(diasTotales);   // set dias totales UI
            }else{
               //todo rolls
            }
        }
    }
    
     public void paySueldo(){
        this.sueldoTotal += (getSueldoHora()*24);
    }  
    
    public double getSueldoTotal(){
        return this.sueldoTotal;
    }
    
}