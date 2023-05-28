/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import productores.AccesoriosProd;
import productores.CarroceriaProd;
import productores.ChasisProd;
import productores.MotorProd;
import productores.WheelsProd;

/**
 *
 * @author Juan
 */
public class Worker extends Thread{
    
    public ChasisProd hireChasisEmployee(Semaphore semChasisProd, Semaphore semChasisCons, Semaphore mutex, String name) {
        
        ChasisProd cp = new ChasisProd(semChasisProd,  semChasisCons, mutex, name);
        
        return cp;
    }
    
    public CarroceriaProd hireCarroceriaProdEmloyee(Semaphore semCarroceriaProd, Semaphore semCarroceriaCons, Semaphore mutex, String name) {
        CarroceriaProd cap = new CarroceriaProd(semCarroceriaProd, semCarroceriaCons, mutex, name);
        return cap;
    }
    
    public MotorProd hireMotorProdEmloyee(Semaphore semMotorProd, Semaphore semMotorCons, Semaphore mutex, String name) {
        MotorProd mp = new MotorProd(semMotorProd, semMotorCons, mutex, name);
        return mp;
    }
    
     public WheelsProd hireWheelsProdEmloyee(Semaphore semWheelsProd, Semaphore semWheelsCons, Semaphore mutex, String name) {
        WheelsProd wp = new WheelsProd(semWheelsProd, semWheelsCons, mutex, name);
        return wp;
    }
     
     public AccesoriosProd hireAccesoriosProdEmloyee(Semaphore semAccesoriosProd, Semaphore semAccesoriosCons, Semaphore mutex, String name) {
        AccesoriosProd ap = new AccesoriosProd(semAccesoriosProd, semAccesoriosCons, mutex, name);
        return ap;
    }
     
//     public Assembler hireAssembler(Semaphore semConsButton, Semaphore semProdButton, Semaphore semProdArms, Semaphore semConsArms, Semaphore semProdLegs, Semaphore semConsLegs, Semaphore semConsBody, Semaphore semProdBody, String name, Semaphore mutex, Semaphore mutexButtons, Semaphore mutexArms, Semaphore mutexLegs, Semaphore mutexBody){
//        Assembler ae = new Assembler(semConsButton, semProdButton, semProdArms, semConsArms,semProdLegs, semConsLegs, semProdBody,semConsBody,name, mutex, mutexButtons, mutexArms, mutexLegs, mutexBody);
//        return e;
//     }
    
}

