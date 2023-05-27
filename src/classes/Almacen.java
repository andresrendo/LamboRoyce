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
    public int carroceriaQty;
    public int motorQty;
    public int accesoriosQty;
    
    public int maxChasisQty;
    public int maxWheelsQty;
    public int maxCarroceriaQty;
    public int maxMotorQty;
    public int maxAccesoriosQty;
    
    public Almacen(int maxChasis, int maxWheels, int maxCarroceria, int maxMotor, int maxAccesorios){
        this.maxChasisQty = maxChasis;
        this.maxWheelsQty = maxWheels;
        this.maxCarroceriaQty = maxCarroceria;
        this.maxMotorQty = maxMotor;
        this.maxAccesoriosQty = maxAccesorios;
        
        
        this.chasisQty = 0;
        this.wheelsQty = 0;
        this.carroceriaQty= 0;
        this.motorQty = 0;
        this.accesoriosQty = 0;
        
    }
    
    public void test(){
        System.out.println("Estoy en warehouse");
    }
    
    public void updateStorage(String workerType, int finishedPart) {
        
        switch (workerType) {
            case "chasis":
                
                if (this.chasisQty < this.maxChasisQty) {
                    this.chasisQty += finishedPart;
                    
                    System.out.println("Chasis producidos: " + this.chasisQty);

                }
                
                
                break;
            case "wheels":
                if (this.wheelsQty < this.maxWheelsQty) {
                    this.wheelsQty += finishedPart;
                    
                    System.out.println("Ruedas producidas: " + this.wheelsQty);
                }
                break;
        // el resto de contadores
            case "carroceria":
                if (this.carroceriaQty < this.maxCarroceriaQty) {
                    this.carroceriaQty += finishedPart;
                    
                    System.out.println("Carrocerias producidas: " + this.carroceriaQty);
                }
                break;
            case "motor":
                if (this.motorQty < this.maxMotorQty) {
                    this.motorQty += finishedPart;
                    
                    System.out.println("motoress producidas: " + this.motorQty);
                }
                break;
            case "accesorios":
                if (this.accesoriosQty < this.maxAccesoriosQty) {
                    this.accesoriosQty += finishedPart;
                    
                    System.out.println("Accesorios producidos: " + this.accesoriosQty);
                }
                break;
            default:
                break;
        }
    }
    
}
