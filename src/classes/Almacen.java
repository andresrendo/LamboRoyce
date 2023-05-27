/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author mannith
 */
public class Almacen {
    public int chasisQty;
    public int wheelsQty;
    
    public int maxChasisQty;
    public int maxWheelsQty;
    
    public Almacen(int maxChasis, int maxWheels){
        this.maxChasisQty = maxChasis;
        this.maxWheelsQty = maxWheels;
        
        this.chasisQty = 0;
        this.wheelsQty = 0;
        
    }
    
    public void test(){
        System.out.println("Estoy en warehouse");
    }
    
    public void updateStorage(String workerType, int finishedPart) {
        
        switch (workerType) {
            case "chasis":
                
                if (this.chasisQty < this.maxChasisQty) {
                    this.chasisQty += finishedPart;
                    
                    System.out.println(this.chasisQty);
                }
                
                
                break;
            case "wheels":
                break;
        // el resto de contadores
            default:
                break;
        }
    }
    
}
