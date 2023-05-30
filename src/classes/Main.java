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

       int[] valoresIniciales =  Configuracion.leerDatosIniciales(); //valoresIniciales[0]:duracion dia, [1]:dias para entrega
       System.out.println(valoresIniciales[0] + "," +  valoresIniciales[1]);
       
//       LamboPlant = new VehiclePlant("Lamborghini", 11, valoresIniciales[0], valoresIniciales[1], true);
       RollsPlant = new VehiclePlant("RollsRoyce", 19, valoresIniciales[0], valoresIniciales[1], false);
       
       Configuracion configuracion = new Configuracion();
       Configuracion configLambo = new Configuracion();
       
       configLambo.leerConfiguracion("src//classes//configuracionLambo.txt");
       configuracion.leerConfiguracion("src//classes//configuracionRolls.txt");
       configuracion.imprimirConfiguracion();
       // Modificar valores de configuración
        configuracion.sumarParametro("chasis", 1);
        // Realizar otras operaciones de configuración

       // Guardar los valores actualizados en el archivo
       configuracion.actualizarConfiguracion("src//classes//configuracionRolls.txt");
       configuracion.imprimirConfiguracion();
        System.out.println("lambo\n");
        configLambo.imprimirConfiguracion();
    }
    
}
