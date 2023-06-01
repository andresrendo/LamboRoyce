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
    public Almacen almacen;
    public Semaphore mutex;
    public boolean isLambo;
    public int cantidadWorkers;
    
    public VehiclePlant (String name, int maxWorkerQty, boolean isLambo) {
        this.name = name;
        this.maxWorkerQty = maxWorkerQty;
        this.workers = new Worker[maxWorkerQty];
        this.emplPorDepto = new int[6];
        this.almacen = new Almacen(25, 35, 20, 55, 10);
        this.mutex = new Semaphore(1);
        this.isLambo = isLambo;
        this.cantidadWorkers = cantidadWorkers ;

        crearWorkers();
    }
    
    
    
    public void crearWorkers(){
        String parametrosEmpl;
        if(isLambo){
            parametrosEmpl = "src//classes//configuracionLambo.txt";
        }else{
            parametrosEmpl = "src//classes//configuracionRolls.txt";
        }
        
        Configuracion configuracion = new Configuracion();
        this.emplPorDepto = configuracion.leerConfiguracion(parametrosEmpl);//leer txt para ver cantidad de empleados por departamento
        
        int cont = 0;
        
        for(int i = 0; i<this.emplPorDepto.length; i++){
            int aux = this.emplPorDepto[i];
            while(aux > 0){
                
                String tipo = TipoWorker.getPiezaCreada(i);
                Worker worker = new Worker(tipo, this.isLambo, Main.gerente.getDayDurationInMs(), this);
                worker.start();
                this.cantidadWorkers +=1;
                this.workers[cont] = worker;
                cont++;
                aux--;
            }
        }                

    }
    public int maxWorkers(){
        System.out.println(maxWorkerQty);
        return maxWorkerQty;
    }
    
    public Worker getWorker(int i){
        return workers[i];
    }
    public int emplContratados(){
        return cantidadWorkers;
    }
}
