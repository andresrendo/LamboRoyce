/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
/**
 *
 * @author Juan
 */
public class Main {
    
    public static VehiclePlant LamboPlant;
    public static VehiclePlant RollsPlant;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//       LamboPlant = new VehiclePlant("LG", 19, 2000);
       RollsPlant = new VehiclePlant("Rolls", 19, 2000);
       Configuracion configuracion = new Configuracion();
       Configuracion configLambo = new Configuracion();

        public static int[] dia =  Configuracion.leerDatosIniciales();
       
       configLambo.leerConfiguracion("src//classes//configuracionLambo.txt");
       configuracion.leerConfiguracion("src//classes//configuracionRolls.txt");
       configuracion.imprimirConfiguracion();
       // Modificar valores de configuración
        configuracion.setParametro("duracion_dia", 3000);
        configuracion.sumarParametro("chasis", 1);
        configuracion.restarParametro("dias_entrega", 2);
        // Realizar otras operaciones de configuración

       // Guardar los valores actualizados en el archivo
       configuracion.actualizarConfiguracion("src//classes//configuracionRolls.txt");
       configuracion.imprimirConfiguracion();
        System.out.println("lambo\n");
        configLambo.imprimirConfiguracion();
    }
    
}
