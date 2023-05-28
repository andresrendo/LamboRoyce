/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productores;

/**
 *
 * @author mannith
 */
public class TipoWorker {
    static public String chasis = "chasis";
    static public String carroceria = "carroceria";
    static public String motor = "motor";
    static public String accesorios = "accesorios";
    static public String ruedas = "ruedas";
    static public String ensamblador = "ensamblador";
        
    public static String getTipoWorker(int i){
        switch (i) {
            case 0:
                return "Chasis";
            case 1:
                return "Carroceria";
            case 2:
                return "Motor";
            case 3:
                return "Accesorios";
            case 4:
                return "Ruedas";
            case 5:
                return "Ensamblador";
        }
        return null;
    }
    public static String getPiezaCreada(int i){
        switch (i) {
            case 0:
                return TipoWorker.chasis;
            case 1:
                return TipoWorker.carroceria;
            case 2:
                return TipoWorker.motor;
            case 3:
                return TipoWorker.accesorios;
            case 4:
                return TipoWorker.ensamblador;
        }
        return null;
    }
}
