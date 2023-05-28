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
    private boolean jobLength;
//    private Worker[] workers;
    private long dayDurationInMs;
    public Almacen almacen;
    public Semaphore mutex;
    
    public VehiclePlant (String name, int maxWorkers, boolean jobLength, long dayDuration) {
        this.name = name;
        this.maxWorkerQty = maxWorkers;
        this.jobLength = true;
        this.dayDurationInMs = dayDuration;
//        this.workers = new Worker[maxWorkerQty];
        this.almacen = new Almacen(25, 35, 20, 55, 10);
        this.mutex = new Semaphore(1);
        
        
    }
    
    Semaphore mutexChasis = new Semaphore(1);
    Semaphore mutexAccesorios = new Semaphore(1);
    Semaphore mutexMotor = new Semaphore(1);
    Semaphore mutexWheels = new Semaphore(1);
    Semaphore mutexCarroceria = new Semaphore (1);
}
//    Semaphore mutexAdmin = new Semaphore(1);
    
//}
