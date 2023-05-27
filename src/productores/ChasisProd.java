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
public class ChasisProd {
    
    private String name;
//    private Almacen almacen;
    private Semaphore mutex;
    private Semaphore semChasisProd;
    private Semaphore semChasisCons;
    private int ChasisPerDay = 1;
    private int cantChasisProduc = 0;
    private String produced = "";
    private boolean start;

    public ChasisProd(Semaphore semChasisProd, Semaphore semChasisCons, Semaphore mutex, String name) {
        this.semChasisProd = semChasisProd;
        this.semChasisCons = semChasisCons;
        this.mutex = mutex;
        this.name = name;
    }

    public void run() {
        while (true) {
                if (this.cantChasisProduc != 1) {
                    try {
                        this.semChasisProd.acquire();
                        this.mutex.acquire();
//                        Almacen.contChasis++;
                        this.cantChasisProduc++;
                        this.mutex.release();
                        this.semChasisCons.release();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ChasisProd.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }
    }


    public int getChasisPerDay() {
        return ChasisPerDay;
    }

    public void setChasisPerDay(int ChasisPerDay) {
        this.ChasisPerDay = ChasisPerDay;
    }

    public void init() {
        this.start = true;
    }

}

//}
