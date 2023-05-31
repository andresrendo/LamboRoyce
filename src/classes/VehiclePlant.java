/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.concurrent.Semaphore;
import productores.TipoWorker;
import productores.Worker;

/**
 *
 * @author mannith
 */
public class VehiclePlant {
    private String name;
    private int maxWorkerQty;    
    private Worker[] workers;
    public int[] emplPorDepto;
    private long dayDurationInMs;
    public Almacen almacen;
    public Semaphore mutex;
    public boolean isLambo;
    private final int daysDeadline;
    
    public VehiclePlant (String name, int maxWorkers, long dayDuration, int daysDeadline, boolean isLambo) {
        this.name = name;
        this.maxWorkerQty = maxWorkers;
        this.dayDurationInMs = dayDuration;
        this.daysDeadline = daysDeadline;
        this.workers = new Worker[maxWorkerQty];
        this.emplPorDepto = new int[6];
        this.almacen = new Almacen(25, 35, 20, 55, 10);
        this.mutex = new Semaphore(1);
        this.isLambo = isLambo;        
        
        String parametrosEmpl;
        if(isLambo){
            parametrosEmpl = "src//classes//configuracionLambo.txt";
        }else{
            parametrosEmpl = "src//classes//configuracionRolls.txt";
        }
        
        Configuracion configuracion = new Configuracion();
        this.emplPorDepto = configuracion.leerConfiguracion(parametrosEmpl);//leer txt para ver cantidad de empleados por departamento
        
        crearWorkers();
    }
    
    public void crearWorkers(){
        int cont = 0;
        
        for(int i = 0; i<this.emplPorDepto.length; i++){
            int aux = this.emplPorDepto[i];
            while(aux > 0){
                
                String tipo = TipoWorker.getPiezaCreada(i);
                Worker worker = new Worker(tipo, this.isLambo, this.dayDurationInMs, this);
                worker.start();
                this.workers[cont] = worker;
                cont++;
                aux--;
            }
        }                
//        for (int i = 0; i<this.maxWorkerQty; i++) {
//            // String tipo, boolean isLambo, long dayDurationInMs, VehiclePlant plant
//            Worker worker = new Worker("chasis", this.isLambo, this.dayDurationInMs, this);
//            worker.start();
//            workers[i] = worker;
//        }
    }
    
}
