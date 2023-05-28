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
public class AccesoriosProd {
    private String name;
//    private Almacen almacen;
    private Semaphore mutex;
    private Semaphore semAccesoriosProd;
    private Semaphore semAccesoriosCons;
    private int AccesoriosPerDay = 1;
    private int cantAccesoriosProduc = 0;
    private String produced = "";
    private boolean start;

    public AccesoriosProd(Semaphore semAccesoriosProd, Semaphore semAccesoriosCons, Semaphore mutex, String name) {
        this.semAccesoriosProd = semAccesoriosProd;
        this.semAccesoriosCons = semAccesoriosCons;
        this.mutex = mutex;
        this.name = name;
    }

    public void run() {
        while (true) {
                if (this.cantAccesoriosProduc != 1) {
                    try {
                        this.semAccesoriosProd.acquire();
                        this.mutex.acquire();
//                        Almacen.contCarroceria++;
                        this.cantAccesoriosProduc++;
                        this.mutex.release();
                        this.semAccesoriosCons.release();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AccesoriosProd.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }  
        }
    }


    public int getAccesoriosPerDay() {
        return AccesoriosPerDay;
    }

    public void setAccesoriosPerDay(int ChasisPerDay) {
        this.AccesoriosPerDay = AccesoriosPerDay;
    }

    public void init() {
        this.start = true;
    }

}
