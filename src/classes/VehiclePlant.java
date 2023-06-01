/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.concurrent.Semaphore;
import javax.swing.JSpinner;
import productores.TipoWorker;
import productores.Worker;

/**
 *
 * @author mannith
 */
public class VehiclePlant {
    private String name;
    public int maxWorkerQty;    
    private Worker[] workers;
    public int[] emplPorDepto = new int[6];
    private long dayDurationInMs;
    public Almacen almacen;
    public Semaphore mutex;
    public boolean isLambo;
    private final int daysDeadline;
    public Configuracion configuracion = new Configuracion();
    
    public VehiclePlant (String name, int maxWorkers, long dayDuration, int daysDeadline, boolean isLambo) {
        this.name = name;
        this.maxWorkerQty = maxWorkers;
        this.dayDurationInMs = dayDuration;
        this.daysDeadline = daysDeadline;
        this.workers = new Worker[maxWorkerQty];
        this.almacen = new Almacen(25, 35, 20, 55, 10);
        this.mutex = new Semaphore(1);
        this.isLambo = isLambo;        
        
        actualizarEmplPorDepto();        
        crearWorkers();
    }
    
    //leer txt para ver cantidad de empleados por departamento
    public void actualizarEmplPorDepto() {        
        String parametrosEmpl;
        if(this.isLambo){
            parametrosEmpl = "src//classes//configuracionLambo.txt";
        }else{
            parametrosEmpl = "src//classes//configuracionRolls.txt";
        }
        
        this.emplPorDepto = configuracion.leerConfiguracion(parametrosEmpl);
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
        
        while (cont < this.maxWorkerQty){
            this.workers[cont] = new Worker(TipoWorker.ninguno, this.isLambo, this.dayDurationInMs, this);
            cont++;
        }
//        for (int i = 0; i<this.maxWorkerQty; i++) {
//            // String tipo, boolean isLambo, long dayDurationInMs, VehiclePlant plant
//            Worker worker = new Worker("chasis", this.isLambo, this.dayDurationInMs, this);
//            worker.start();
//            workers[i] = worker;
//        }
    }
    
    public Worker getWorker(int i){
        return this.workers[i];
    }
    
    public void reorganizarTrabajadores(JSpinner[] spinners){
        int cantCounter = 0;
        int workersCounter = 0;
        //int[] producersQty = new int[6];
        
        actualizarEmplPorDepto();        
        
        for (int i = 0; i < this.emplPorDepto.length; i++) {
           
            int cantPorDepto = this.emplPorDepto[i];
            for (int j = 0; j < cantPorDepto; j++) {
                
                getWorker(workersCounter).setWorkerType(TipoWorker.getPiezaCreada(cantCounter));
                workersCounter += 1;
            }
            
            //producersQty[cantCounter] = typeAmount;
            cantCounter+=1;
        }
        
        while (workersCounter <= this.maxWorkerQty){
            getWorker(workersCounter).setWorkerType(TipoWorker.ninguno);
            workersCounter += 1;
        }
        
        //setear salario mensual
    }
    
}
