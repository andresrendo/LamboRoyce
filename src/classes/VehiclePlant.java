/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author mannith
 */
public class VehiclePlant {
    private String name;
    private int maxWorkerQty;
    private Worker[] workers;
    private long dayDurationInMs;
    public Almacen warehouse;
    public Semaphore mutex;
    
    public VehiclePlant (String name, int maxWorkers, long dayDuration) {
        this.name = name;
        this.maxWorkerQty = maxWorkers;
        this.dayDurationInMs = dayDuration;
        this.workers = new Worker[maxWorkerQty];
        this.warehouse = new Almacen(20, 35, 20, 55, 10);
        this.mutex = new Semaphore(1);
        
        initializeWorkers();
        
        
    }
    
    public void initializeWorkers(){
        for (int i = 0; i<this.maxWorkerQty; i++) {
            Worker chasis = new Worker(0.34f, 20, this.dayDurationInMs, "chasis", this);
            chasis.start(); //hardcodeado
            workers[i] = chasis;
//            Worker wheels = new Worker(0.34f, 20, this.dayDurationInMs, "wheels", this);
//            wheels.start(); //hardcodeado
//            workers[i] = wheels;
        }
    }
}
