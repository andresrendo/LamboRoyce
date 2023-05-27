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
public class CarroceriaProd {
    private String name;
//    private Almacen almacen;
    private Semaphore mutex;
    private Semaphore semCarroceriaProd;
    private Semaphore semCarroceriaCons;
    private int CarroceriaPerDay = 1;
    private int cantCarroceriaProduc = 0;
    private String produced = "";
    private boolean start;

    public CarroceriaProd(Semaphore semCarroceriaProd, Semaphore semCarroceriaCons, Semaphore mutex, String name) {
        this.semCarroceriaProd = semCarroceriaProd;
        this.semCarroceriaCons = semCarroceriaCons;
        this.mutex = mutex;
        this.name = name;
    }

    public void run() {
        while (true) {
                if (this.cantCarroceriaProduc != 1) {
                    try {
                        this.semCarroceriaProd.acquire();
                        this.mutex.acquire();
//                        Almacen.contCarroceria++;
                        this.cantCarroceriaProduc++;
                        this.mutex.release();
                        this.semCarroceriaCons.release();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ChasisProd.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }  
        }
    }


    public int getCarroceriaPerDay() {
        return CarroceriaPerDay;
    }

    public void setCarroceriaPerDay(int ChasisPerDay) {
        this.CarroceriaPerDay = ChasisPerDay;
    }

    public void init() {
        this.start = true;
    }

}

//}
