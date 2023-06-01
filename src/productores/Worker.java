/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productores;

import classes.Main;
import classes.VehiclePlant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mannith
 */
public class Worker extends Thread{
    private double sueldoTotal;
    private double sueldoPorHora;
    private long dayDurationInMs;
    private double produceAlDia;
    private double cuentaPieza;
    private String workerPieza;
    
    final private boolean active = true;
    private boolean isEnsamblador;
    private boolean isLambo;
    private VehiclePlant plant;
    
  


    
    public Worker(String tipo, boolean isLambo, long dayDurationInMs, VehiclePlant plant){
        this.workerPieza = tipo;
        this.sueldoTotal = 0;
        this.cuentaPieza = 0;
        this.isLambo = isLambo;
        this.dayDurationInMs = dayDurationInMs;
        this.plant = plant;
        this.initializeWorker();
    }
    
    
    @Override
    public void run(){
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(this.active){
            try {
                
             this.produceForTheDay();
             this.payCheck();
             
//             System.out.println(this.accSalary);
            sleep(this.dayDurationInMs);

            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void initializeWorker(){
        
        if (this.workerPieza.equals(TipoWorker.chasis)) {
            this.sueldoPorHora = 10;
            this.produceAlDia = this.getProdChasisDia(this.isLambo);
        }
        else if (this.workerPieza.equals(TipoWorker.carroceria)) {
            this.sueldoPorHora = 13;
            this.produceAlDia = this.getProdCarroceriaDia(this.isLambo);
        }
        else if (this.workerPieza.equals(TipoWorker.motor)) {
            this.sueldoPorHora = 20;
            this.produceAlDia = this.getProdMotorDia(this.isLambo);
        }
        else if (this.workerPieza.equals(TipoWorker.ruedas)) {
             this.sueldoPorHora = 8;
             this.produceAlDia = this.getProdRuedasDia(this.isLambo);
        }
        else if (this.workerPieza.equals(TipoWorker.accesorios)) {
             this.sueldoPorHora = 17;
             this.produceAlDia = this.getProdAccDia(this.isLambo);        
        }
        else if (this.workerPieza.equals(TipoWorker.ensamblador)) {
             this.sueldoPorHora = 25;
             this.produceAlDia = 0;
             this.isEnsamblador = true;
             return;        
        }
        else {
             this.sueldoPorHora = 0;
             this.produceAlDia = 0;             
        }
        setCuentaPieza(0);
        setIsEnsamblador(false);                
    }
        
    
    private double getProdChasisDia(boolean isLambo){
        if (isLambo){
            return 0.5;
        }
        return 0.25;
    }
    private double getProdCarroceriaDia(boolean isLambo){
        if (isLambo){
            return 0.5;
        }
        return 0.25;
    }
    private double getProdMotorDia(boolean isLambo){
        if (isLambo){
            return 3;
        }
        return 1;
    }
    private double getProdRuedasDia(boolean isLambo){
        if (isLambo){
            return 3;
        }
        return 5;
    }
    private double getProdAccDia(boolean isLambo){
        if (isLambo){
            return 0.34;
        }
        return 0.5;
    }

    public void produceForTheDay(){
        this.cuentaPieza += this.produceAlDia;
        
        if (this.cuentaPieza >= 1) {
            try {
                plant.mutex.acquire();
                plant.almacen.updateStorage(this.workerPieza, (int) this.cuentaPieza );
                plant.mutex.release();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
            // intentar acceder al almacén
            this.cuentaPieza = 0;
        }
        if (this.isEnsamblador){
            try{
                plant.mutex.acquire();
                boolean partsTaken = plant.almacen.takeParts(this.isLambo);
                plant.mutex.release();
                
                //una vez tomadas las piezas, dormir 2 dias que tarda en hacer el carro (solo si tomo las piezas)
                if(partsTaken){
                    sleep(this.dayDurationInMs * 2);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
    public void setTipoWorker(String tipo){
        this.workerPieza = tipo;
        this.initializeWorker();
    }
    
    public String getTipoWorker(){
        return this.workerPieza;
    }
    
    public double getSueldoTotal(){
        return this.sueldoTotal;
    }
    
    public double getSueldoHora(){
        return this.sueldoPorHora;
    }
    
    public void payCheck(){
        this.sueldoTotal += (getSueldoHora()*24);
    }  

    
    public double getProduccionDiaria() {
        return produceAlDia;
    }

    public void setProduccionDiaria(double produceAlDia) {
        this.produceAlDia = produceAlDia;
    }

    public double getAccProduction() {
        return cuentaPieza;
    }

    public void setCuentaPieza(double cuentaPieza) {
        this.cuentaPieza = cuentaPieza;
    }

    public String getWorkerPieza() {
        return workerPieza;
    }

    public void setWorkerPieza(String workerPieza) {
        this.workerPieza = workerPieza;
    }

    public boolean isEnsamblador() {
        return isEnsamblador;
    }

    public void setIsEnsamblador(boolean isEnsamblador) {
        this.isEnsamblador = isEnsamblador;
    }
    
    
}