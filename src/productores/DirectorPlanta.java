/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productores;

/**
 *
 * @author mannith
 */
import classes.Almacen;
import classes.Main;
import classes.VehiclePlant;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class DirectorPlanta extends Thread {
    //private int diasRestantes;
    //private Gerente gerente;
    private double sueldoTotal;
    private double sueldoPorHora;
    private int faltas;
    private boolean isLambo;
    private VehiclePlant plant;

    public DirectorPlanta(VehiclePlant plant, boolean isLambo) {
        this.plant = plant;
        this.faltas = 0;
        this.isLambo = isLambo;
        this.sueldoPorHora = 30;
        this.sueldoTotal = 0;
    }
    
    
    public int getFaltas() {
        return faltas;
    }
    
    public void paySueldo(){
        this.sueldoTotal += (getSueldoHora()*24);
    }
    
    public double getSueldoHora(){
        return this.sueldoPorHora;
    }
    
    public double getSueldoTotal(){
        return this.sueldoTotal;
    }

    public int calcularSaldoFinalGerente() {
        int descuentoPorFalta = 50; // Monto de descuento por cada falta
        int sueldoGerente = 14600;
        int saldoFinalGerente = sueldoGerente - (faltas * descuentoPorFalta);
        return saldoFinalGerente;
    }
    
    private double calcularGananciasCarrosVendidos(int totalCarros, int totalCarrosAcc, int precioCarro, int precioAcce) {
    // Aquí puedes implementar la lógica para calcular las ganancias de los carros vendidos
    // Puedes utilizar los valores de totalCarros y totalCarrosAcc para calcular las ganancias
    // y devolver el resultado

    // Ejemplo de cálculo de ganancias:
    double ganancias = totalCarros * precioCarro + totalCarrosAcc * precioAcce;
    return ganancias;
}
    
    @Override
    public void run() {
        Random random = new Random(); // Generador de números aleatorios
        while (true) {
            //System.out.println(Main.gerente.getDaysDeadline());
            if (plant.daysDeadline == 0) {
                int sueldosPagados = calcularSalariosMensuales(isLambo);
                int carrosEnviadosLambo = Main.LamboPlant.almacen.getTotalCarros() + Main.LamboPlant.almacen.getTotalCarrosAcc();
                int carrosEnviadosRoyce = Main.RollsPlant.almacen.getTotalCarros() + Main.RollsPlant.almacen.getTotalCarrosAcc();
                double gananciaBrutaLambo = calcularGananciasCarrosVendidos(Main.LamboPlant.almacen.getTotalCarros(), Main.LamboPlant.almacen.getTotalCarrosAcc(), 400000, 750000);
                double gananciaBrutaRoyce = calcularGananciasCarrosVendidos(Main.RollsPlant.almacen.getTotalCarros(), Main.RollsPlant.almacen.getTotalCarrosAcc(), 450000, 900000);
                System.out.println("carros lambo enviados" + carrosEnviadosLambo);
                System.out.println("Ganancia bruta planta Lambo: " + gananciaBrutaLambo + "$");
                System.out.println("carros Royce enviados" + carrosEnviadosRoyce);
                System.out.println("Ganancia bruta planta Lambo: " + gananciaBrutaRoyce + "$");

                // Enviar vehículos al concesionario
                System.out.println("Enviando vehículos al concesionario...");
                // Simulamos el tiempo que toma enviar los vehículos
                try {
                    Thread.sleep(plant.dayDurationInMs); // 24 horas
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // Realizar tareas administrativas
//                System.out.println("Director realizando tareas administrativas...");
                // Verificar lo que está haciendo el gerente
                try {
                int randomHour = random.nextInt(24); // Generar una hora aleatoria del día
                int randomMin = random.nextInt(60);
                for (int i = 0; i < 24; i++) { // Simulando cada hora del día
                    if (i == randomHour) {
                        for(int j=0; j<60;j++){
                            if(j==randomMin){
                                //cambio a "supervisando"
                                if(isLambo){
                                    dashboard.GlobalUI.getMainUI().getLGdashboard1().setDirectorAccion("Supervisando al gerente");
                                }else{
                                    //todo rolls
//                                    dashboard.GlobalUI.getMainUI().getRRdashboard1().setDirectorAccion("Supervisando al gerente");
                                }                                
                                verificarActividadGerente();
                            }
                            Thread.sleep(plant.dayDurationInMs / (24*60));
                        }
                    }
                    //
                    Thread.sleep(plant.dayDurationInMs / 24); // Espera una hora en tiempo de simulación
                }
                        } catch(InterruptedException e){
                            e.printStackTrace();
                        }
            }
        }
    }


    public void verificarActividadGerente() throws InterruptedException {
        System.out.println("Director supervisando al gerente");

        if (plant.gerente.estaViendoCarreras()) {
            // El gerente está viendo carreras
            System.out.println("Falta al gerente por ver carreras. Se descontarán $50 de su sueldo.");
            faltas++;
            
            if(isLambo){
                dashboard.GlobalUI.getMainUI().getLGdashboard1().setFaltasLabel(faltas);
                int sal = this.calcSalarioRestado(faltas);
                dashboard.GlobalUI.getMainUI().getLGdashboard1().setSueldoDescontado(sal);
            }else{
                //todo rolls
//                dashboard.GlobalUI.getMainUI().getRRdashboard1().setFaltasLabel(faltas);
//                int sal = this.calcSalarioRestado(faltas);
//                dashboard.GlobalUI.getMainUI().getRRdashboard1().setSueldoDescontado(sal);
            }
//            Main.gerente.dejarDeVerCarreras(); // El gerente deja de ver carreras
        } else {
            // El gerente está trabajando
            System.out.println("El gerente está trabajando.");
        }
        Thread.sleep(plant.dayDurationInMs / 57);//sleep 25 minutos
        //cambio a trabajando
        if(isLambo){
            dashboard.GlobalUI.getMainUI().getLGdashboard1().setDirectorAccion("Trabajando");
        }else{
            //todo rolls
//            dashboard.GlobalUI.getMainUI().getRRdashboard1().setDirectorAccion("Trabajando");
        }
    }
 
    public int calcSalarioRestado(int faltas){
        int totalRestado = faltas * 50;
        return totalRestado;
    }
    
    public int calcularSalariosMensuales(boolean isLambo){

        int total = 0;
        if(isLambo){
                for(int i = 0; i< Main.LamboPlant.emplContratados(); i++){
                    total += Main.LamboPlant.getWorker(i).getSueldoTotal();
                    
//                    System.out.println(total);
                }
                System.out.println(total);
                return total;
            }else{
                for(int i = 0; i<Main.RollsPlant.emplContratados();i++){
                    total += Main.RollsPlant.getWorker(i).getSueldoTotal();
                    
                    }
//                System.out.println("la otra planta" + total);
            return total;
            }
        }
      
}