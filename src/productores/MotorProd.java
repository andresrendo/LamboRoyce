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
public class MotorProd {
    private String name;
//    private Almacen almacen;
    private Semaphore mutex;
    private Semaphore semMotorProd;
    private Semaphore semMotorCons;
    private int MotorPerDay = 1;
    private int cantMotorProduc = 0;
    private String produced = "";
    private boolean start;

    public MotorProd(Semaphore semMotorProd, Semaphore semMotorCons, Semaphore mutex, String name) {
        this.semMotorProd = semMotorProd;
        this.semMotorCons = semMotorCons;
        this.mutex = mutex;
        this.name = name;
    }

    public void run() {
        while (true) {
                if (this.cantMotorProduc != 1) {
                    try {
                        this.semMotorProd.acquire();
                        this.mutex.acquire();
//                        Almacen.contCarroceria++;
                        this.cantMotorProduc++;
                        this.mutex.release();
                        this.semMotorCons.release();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ChasisProd.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }  
        }
    }


    public int getMotorPerDay() {
        return MotorPerDay;
    }

    public void setMotorPerDay(int ChasisPerDay) {
        this.MotorPerDay = ChasisPerDay;
    }

    public void init() {
        this.start = true;
    }

}

