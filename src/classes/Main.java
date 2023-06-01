/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dashboard.Dashboard;
import productores.Gerente;
import productores.DirectorPlanta;

/**
 *
 * @author Juan
 */
public class Main {
    
    
    public static VehiclePlant LamboPlant;
    public static VehiclePlant RollsPlant;
    public static Gerente gerente;
    public static DirectorPlanta director;
    public static Almacen almacen;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("ola");
//        boolean isLambo = true;
       director = new DirectorPlanta(1,0, true);
       gerente = new Gerente(1,0,8000);
       LamboPlant = new VehiclePlant("Lamborghini", 11, true);
       RollsPlant = new VehiclePlant("RollsRoyce", 19, false);
       
//       Configuracion configuracion = new Configuracion();
//       Configuracion configLambo = new Configuracion();
       
//       configLambo.leerConfiguracion("src//classes//configuracionLambo.txt");
//       configuracion.leerConfiguracion("src//classes//configuracionRolls.txt");
//       configuracion.imprimirConfiguracion();
       // Modificar valores de configuración
//        configuracion.sumarParametro("chasis", 1);
        // Realizar otras operaciones de configuración

       // Guardar los valores actualizados en el archivo
//       configuracion.actualizarConfiguracion("src//classes//configuracionRolls.txt");
//       configuracion.imprimirConfiguracion();
//        System.out.println("lambo\n");
//        configLambo.imprimirConfiguracion();
        Dashboard interfaz = new Dashboard();
        interfaz.setVisible(true);
        // Iniciar los hilos
        director.start();
        gerente.start();

    }
    
}
