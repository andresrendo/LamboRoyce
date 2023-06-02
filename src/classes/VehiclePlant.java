/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.concurrent.Semaphore;
import javax.swing.JSpinner;
import productores.DirectorPlanta;
import productores.Gerente;
import productores.TipoWorker;
import productores.Worker;

/**
 *
 * @author mannith
 */
public class VehiclePlant extends Thread{
    private String name;
    public int maxWorkerQty;    
    private Worker[] workers;
    public int[] emplPorDepto;
    public long dayDurationInMs;
    public Almacen almacen;
    public Semaphore mutex;
    public boolean isLambo;
    public int daysDeadline;
    public Configuracion configuracion = new Configuracion();
    public int cantidadWorkers;
    public Gerente gerente;
    public DirectorPlanta director;
    public int diasInicio;
    private int sueldosAcumulados;
    private int carrosVendidos;

    
    public VehiclePlant (String name, int maxWorkerQty, int dayDurationMs, int deadline, boolean isLambo) {
        this.name = name;
        this.maxWorkerQty = maxWorkerQty;
        this.workers = new Worker[maxWorkerQty];
        this.almacen = new Almacen(25, 35, 20, 55, 10);
        this.mutex = new Semaphore(1);
        this.isLambo = isLambo;
        this.daysDeadline = deadline;
        this.dayDurationInMs = dayDurationMs;
        this.director = new DirectorPlanta(this,isLambo);
        this.gerente = new Gerente(this,dayDurationMs);
        this.diasInicio = deadline;
        this.sueldosAcumulados = 0;
        
        dashboard.GlobalUI.getMainUI().getMainDashboard().getDayDurationSpinner().setValue(this.dayDurationInMs/1000);
        
        actualizarEmplPorDepto();        
        crearWorkers();
        startGerenteDir();
        this.start();
    }       
    
    @Override
    public void run() {
              while(true){
            try {                
                //get sueldos
                int num = this.getSueldosPagados();
                if(this.isLambo){
                    dashboard.GlobalUI.getMainUI().getMainDashboard().getDashboardInfoLg().setSueldosLabel(num);
                    dashboard.GlobalUI.getMainUI().getLGdashboard1().getDashboardInfo().setSueldosLabel(num);
                }else{
                    dashboard.GlobalUI.getMainUI().getMainDashboard().getDashboardInfoRr().setSueldosLabel(num);
                    dashboard.GlobalUI.getMainUI().getRrDashboard1().getDashboardInfo().setSueldosLabel(num);
                }
                //get ganancias
                // get utilidad (ganancias - sueldos)
                int ganancias = this.almacen.getCarsUtility(isLambo);
                int utilidad = ganancias - num;
                if(this.isLambo){
                    dashboard.GlobalUI.getMainUI().getMainDashboard().getDashboardInfoLg().setUtilidadTotal(utilidad);
                    dashboard.GlobalUI.getMainUI().getLGdashboard1().getDashboardInfo().setUtilidadTotal(utilidad);
                }else{
                    dashboard.GlobalUI.getMainUI().getMainDashboard().getDashboardInfoRr().setUtilidadTotal(utilidad);
                    dashboard.GlobalUI.getMainUI().getRrDashboard1().getDashboardInfo().setUtilidadTotal(utilidad);
                }
                
                //setear daysdeadline y duration en UI
                dashboard.GlobalUI.getMainUI().getMainDashboard().setDeadlineSpinner(this.daysDeadline);
                dashboard.GlobalUI.getMainUI().getMainDashboard().setDayDurationSpinner((int) (this.dayDurationInMs/1000));
                
                
                Thread.sleep(this.dayDurationInMs);
            } catch (InterruptedException ex){
                System.out.println("error");
            }
        }
    }

    public void startGerenteDir(){
        this.gerente.start();
        this.director.start();
    }
    
    public int getSueldosPagados(){
        int total = 0;
        for(int i = 0; i<this.workers.length; i++){
            total += this.getWorker(i).getSueldoTotal();
        }
        total += this.getDirector().getSueldoTotal();
        total += this.getSueldoGerente();
        this.sueldosAcumulados += total;
        return (total);
    }
    
    public int getSueldoGerente(){
        int total = 0;
        int faltas = 0;
        
        faltas = this.director.getFaltas();
        total = (int) this.gerente.getSueldoTotal();
        total = total - (faltas * 50);
        
        return total;
    }
    
    public void actualizarEmplPorDepto(){
        String parametrosEmpl;
        if(isLambo){
            parametrosEmpl = "src//classes//configuracionLambo.txt";
        }else{
            parametrosEmpl = "src//classes//configuracionRolls.txt";
        }
                
        this.emplPorDepto = this.configuracion.leerConfiguracion(parametrosEmpl);//leer txt para ver cantidad de empleados por departamento
    }
    
//    public void setUpW()
    
    public void crearWorkers(){                        
        int cont = 0;
        
        for(int i = 0; i<this.emplPorDepto.length; i++){
            int aux = this.emplPorDepto[i];
            while(aux > 0){
                
                String tipo = TipoWorker.getPiezaCreada(i);
                Worker worker = new Worker(tipo, this.isLambo, gerente.getDayDurationInMs(), this);
                worker.start();
                this.cantidadWorkers +=1;
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
    
    public void reorganizarTrabajadores(){
        int cantCounter = 0;
        int workersCounter = 0;
        //int[] workersQty = new int[6];
        
        actualizarEmplPorDepto();        
        
        for (int i = 0; i < this.emplPorDepto.length; i++) {
           
            int cantPorDepto = this.emplPorDepto[i];
            for (int j = 0; j < cantPorDepto; j++) {
                
                getWorker(workersCounter).setWorkerType(TipoWorker.getPiezaCreada(cantCounter));
                workersCounter += 1;
            }
                        
            cantCounter+=1;
        }
        
        while (workersCounter <= this.maxWorkerQty){
            getWorker(workersCounter).setWorkerType(TipoWorker.ninguno);
            workersCounter += 1;
        }
        
        //setear salario mensual
    }
    
    public void setDayDurationInMs(int dayDuration){
        this.dayDurationInMs = dayDuration;
    }
    
    public void setDaysDeadline(int day){
        this.daysDeadline = day;
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
    
    public int restartDeadLine(){
        this.carrosVendidos += this.almacen.totalCarros + this.almacen.totalCarrosAcc;
        if(isLambo){
            dashboard.GlobalUI.getMainUI().getLGdashboard1().setCarrosVendidos(this.carrosVendidos);
        }else{
            dashboard.GlobalUI.getMainUI().getRrDashboard1().setCarrosVendidos(this.carrosVendidos);
        }
        return this.daysDeadline = diasInicio;        
    }
    
    public DirectorPlanta getDirector(){
        return this.director;
    }
    
    public Gerente getGerente(){
        return this.gerente;
    }

}
