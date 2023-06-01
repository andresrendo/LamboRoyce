/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dashboard;

import classes.VehiclePlant;
import productores.TipoWorker;

/**
 *
 * @author Juan
 */
public class Functions {
    
    public static int validarCantEmpl(VehiclePlant plant, String tipo, int valor){
        int[] auxCantEmpl = plant.emplPorDepto;
        auxCantEmpl[TipoWorker.getIndexTipoWorker(tipo)] = valor; // pongo valor en el array de cantEmplAux para ver si es valido
        int newValor = valor;
        int count = calcWorkersQty(auxCantEmpl);
        
        if(count <= plant.maxWorkerQty){
            //actualizo plant.configuracion del valor (chasis, carroceria, etc)
            plant.configuracion.setParametro(tipo, newValor);
            //guardo en el txt los nuevos valores, lambo o no
            if(plant.isLambo){
                plant.configuracion.actualizarConfiguracion("src//classes//configuracionLambo.txt");
            }else {
                plant.configuracion.actualizarConfiguracion("src//classes//configuracionRolls.txt");
            }
            //leo txt para actualizar empleados por depto
            plant.actualizarEmplPorDepto();
            
            return newValor;
        } else {
            //retorno el valor original
            return (newValor - 1);
        }
      
    }
    
    
    
    public static int calcWorkersQty(int[] cantEmpl) {
        int aux = 0;
        for(int i = 0; i< cantEmpl.length; i++){
            aux += cantEmpl[i];
        }
        return aux;
    }
    
}
