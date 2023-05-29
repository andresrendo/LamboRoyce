/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.concurrent.Semaphore;
import productores.Worker;

/**
 *
 * @author mannith
 */
public class VehiclePlant {
    private String name;
    private int maxWorkerQty;    
    private Worker[] workers;
    private int[] emplPorDepto;
    private long dayDurationInMs;
    public Almacen almacen;
    public Semaphore mutex;
    
    public VehiclePlant (String name, int maxWorkers, boolean jobLength, long dayDuration) {
        this.name = name;
        this.maxWorkerQty = maxWorkers;
        this.dayDurationInMs = dayDuration;
        this.workers = new Worker[maxWorkerQty];
        this.emplPorDepto = new int[6];
        this.almacen = new Almacen(25, 35, 20, 55, 10);
        this.mutex = new Semaphore(1);
        
        crearWorkers();
    }
    
    public void crearWorkers(){
        for (int i = 0; i<this.maxWorkerQty; i++) {
            // String tipo, boolean isLambo, long dayDurationInMs, VehiclePlant plant
            Worker worker = new Worker("chasis", true, 2000, this);
            worker.start();
            workers[i] = worker;
        }
    }
    
}
