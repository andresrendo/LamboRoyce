/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productores;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mannith
 */
public class WheelsProd {
    private String name;
//    private Almacen almacen;
    private Semaphore mutex;
    private Semaphore semWheelsProd;
    private Semaphore semWheelsCons;
    private int WheelsPerDay = 1;
    private int cantWheelsProduc = 0;
    private String produced = "";
    private boolean start;

    public WheelsProd(Semaphore semWheelsProd, Semaphore semWheelsCons, Semaphore mutex, String name) {
        this.semWheelsProd = semWheelsProd;
        this.semWheelsCons = semWheelsCons;
        this.mutex = mutex;
        this.name = name;
    }

    public void run() {
        while (true) {
                if (this.cantWheelsProduc != 1) {
                    try {
                        this.semWheelsProd.acquire();
                        this.mutex.acquire();
//                        Almacen.contCarroceria++;
                        this.cantWheelsProduc++;
                        this.mutex.release();
                        this.semWheelsCons.release();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ChasisProd.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }  
        }
    }


    public int getWheelsPerDay() {
        return WheelsPerDay;
    }

    public void setWheelsPerDay(int ChasisPerDay) {
        this.WheelsPerDay = ChasisPerDay;
    }

    public void init() {
        this.start = true;
    }

}