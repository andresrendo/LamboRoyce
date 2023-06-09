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
    
    public int totalCarros; // total de carros producidos
    public int contConAcc; // variable auxiliar para saber cuando se debe crear con accesorio
    public int totalCarrosAcc; // total de carros producidos con accesorios
    
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
        this.totalCarros = 0;
        this.contConAcc = 0;
        this.totalCarrosAcc = 0;
    }
    
    public void test(){
        System.out.println("Estoy en warehouse");
    }
    
    public int getTotalCarros() {
        return totalCarros;
    }

    public int getTotalCarrosAcc() {
        return totalCarrosAcc;
    }
    
    public void updateStorage(String workerType, int finishedPart, boolean isLambo) {
        
        switch (workerType) {
            
            case "chasis":       
                if (this.chasisQty < this.maxChasisQty) {
                    this.chasisQty += finishedPart;
                    
                    if (this.chasisQty > this.maxChasisQty){
                        this.chasisQty = this.maxChasisQty;
                    }
                    if(isLambo){
                        dashboard.GlobalUI.getMainUI().getLGdashboard1().setChasisQtyLabel(this.chasisQty);
                    }else {                         
                        dashboard.GlobalUI.getMainUI().getRrDashboard1().setChasisQtyLabel(this.chasisQty);
                    }
                    System.out.println("Chasis producidos: " + this.chasisQty);
                }
                break;
                
            case "ruedas":
                if (this.wheelsQty < this.maxWheelsQty) {
                    this.wheelsQty += finishedPart;
                    
                    if (this.wheelsQty > this.maxWheelsQty){
                        this.wheelsQty = this.maxWheelsQty;
                    }
                    if(isLambo){
                        dashboard.GlobalUI.getMainUI().getLGdashboard1().setRuedasQtyLabel(this.wheelsQty);
                    }else{
                        dashboard.GlobalUI.getMainUI().getRrDashboard1().setRuedasQtyLabel(this.wheelsQty);
                    }
                    System.out.println("Ruedas producidas: " + this.wheelsQty);
                }
                break;
                
        // el resto de contadores
            case "carroceria":
                if (this.carroceriaQty < this.maxCarroceriaQty) {
                    this.carroceriaQty += finishedPart;
                    
                    if (this.carroceriaQty > this.maxCarroceriaQty){
                        this.carroceriaQty = this.maxCarroceriaQty;
                    }
                    if(isLambo){
                        dashboard.GlobalUI.getMainUI().getLGdashboard1().setCarrQtyLabel(this.carroceriaQty);
                    }else{
                        dashboard.GlobalUI.getMainUI().getRrDashboard1().setCarrQtyLabel(this.carroceriaQty);
                    }
                    System.out.println("Carrocerias producidas: " + this.carroceriaQty);
                }
                break;
                
            case "motor":
                if (this.motorQty < this.maxMotorQty) {
                    this.motorQty += finishedPart;
                    
                    if (this.motorQty > this.maxMotorQty){
                        this.motorQty = this.maxMotorQty;
                    }
                    if(isLambo){
                        dashboard.GlobalUI.getMainUI().getLGdashboard1().setMotorQtyLabel(this.motorQty);
                    } else{
                        dashboard.GlobalUI.getMainUI().getRrDashboard1().setMotorQtyLabel(this.motorQty);
                    }
                    System.out.println("motores producidos: " + this.motorQty);
                }
                break;
                
            case "accesorios":
                if (this.accesoriosQty < this.maxAccesoriosQty) {
                    this.accesoriosQty += finishedPart;
                    
                    if (this.accesoriosQty > this.maxAccesoriosQty){
                        this.accesoriosQty = this.maxAccesoriosQty;
                    }
                    if(isLambo){
                        dashboard.GlobalUI.getMainUI().getLGdashboard1().setAccQtyLabel(this.accesoriosQty);
                    } else{
                        dashboard.GlobalUI.getMainUI().getRrDashboard1().setAccQtyLabel(this.accesoriosQty);
                    }
                    System.out.println("Accesorios producidos: " + this.accesoriosQty);
                }
                break;
                
            default:
                break;
        }
    }
    
    public boolean takeParts(boolean isLambo){
        if(isLambo){
            //revisar contador de carros para saber si necesito accesorios
            if (this.contConAcc == 3){
                //revisar en almacen si estan disponibles las partes y accesorios y tomarlas
                if(this.hayStock(isLambo) && this.hayStockAcc(isLambo)){
                    //restar stock del almacen y contadorAcc a 0
                    this.restarStock(isLambo, true);
                    this.contConAcc = 0;
                    this.totalCarrosAcc += 1;
                    System.out.println("Hizo un carro");
                    int plata = this.getCarsUtility(isLambo);                    
                    dashboard.GlobalUI.getMainUI().getLGdashboard1().getDashboardInfo().setGananciaNeta(plata);
                    dashboard.GlobalUI.getMainUI().getMainDashboard().getDashboardInfoLg().setGananciaNeta(plata);
                    dashboard.GlobalUI.getMainUI().getLGdashboard1().setQtyCarrosAccProd(this.totalCarrosAcc);
                    return true;
                }
                return false;

            }else {
                //revisar en almacen si estan disponibles las partes y tomarlas
                if(this.hayStock(isLambo)){
                    this.restarStock(isLambo, false);
                    this.contConAcc += 1;
                    this.totalCarros += 1;
                    System.out.println("Hizo un carro");
                    int plata = this.getCarsUtility(isLambo);                    
                    dashboard.GlobalUI.getMainUI().getLGdashboard1().getDashboardInfo().setGananciaNeta(plata);
                    dashboard.GlobalUI.getMainUI().getMainDashboard().getDashboardInfoLg().setGananciaNeta(plata);
                    dashboard.GlobalUI.getMainUI().getLGdashboard1().setQtyCarrosProd(this.totalCarros);
                    return true;
                }
                return false;
            }
        
        }else {
                //revisar contador de carros para saber si necesito accesorios
            if (this.contConAcc == 6){
                //revisar en almacen si estan disponibles las partes y accesorios y tomarlas
                if(this.hayStock(isLambo) && this.hayStockAcc(isLambo)){
                    //restar stock del almacen y contadorAcc a 0
                    this.restarStock(isLambo, true);
                    this.contConAcc = 0;
                    this.totalCarrosAcc += 1; 
                    int plata = this.getCarsUtility(isLambo);
                    dashboard.GlobalUI.getMainUI().getMainDashboard().getDashboardInfoRr().setGananciaNeta(plata);
                    //  ganancia rr dashboard
                    dashboard.GlobalUI.getMainUI().getRrDashboard1().getDashboardInfo().setGananciaNeta(plata);
                    dashboard.GlobalUI.getMainUI().getRrDashboard1().setQtyCarrosProd(this.totalCarros);
                    return true;
                }
                return false;

            }else {
                //revisar en almacen si estan disponibles las partes y tomarlas
                if(this.hayStock(isLambo)){
                    this.restarStock(isLambo, false);
                    this.contConAcc += 1;
                    this.totalCarros += 1;
                    int plata = this.getCarsUtility(isLambo);
                    dashboard.GlobalUI.getMainUI().getMainDashboard().getDashboardInfoRr().setGananciaNeta(plata);
                    // ganancia rr dashboard
                    dashboard.GlobalUI.getMainUI().getRrDashboard1().getDashboardInfo().setGananciaNeta(plata);
                    dashboard.GlobalUI.getMainUI().getRrDashboard1().setQtyCarrosProd(this.totalCarros);
                    return true;
                }
                return false;
            }
        }                        
    }
    
    public boolean hayStock(boolean isLambo){
        
        if(isLambo){
            return (this.carroceriaQty >= 1 && this.chasisQty >= 2 && this.motorQty >= 6 && this.wheelsQty >= 5);
        }
        return (this.carroceriaQty >= 2 && this.chasisQty >= 3 && this.motorQty >= 4 && this.wheelsQty >= 6);
    }
    
    public boolean hayStockAcc(boolean isLambo){
        if(isLambo){
            return this.accesoriosQty >= 1;
        }
        return this.accesoriosQty >= 5;
    }
    
    public void restarStock(boolean isLambo, boolean conAcc){
        //restar partes para cada empresa
        if(isLambo){
            this.carroceriaQty -= 1;
            this.chasisQty -= 2;
            this.motorQty -= 6;
            this.wheelsQty -= 5;            
            if(conAcc){
                this.accesoriosQty -= 1;
            }
            //act valores en interfaz
            dashboard.GlobalUI.getMainUI().getLGdashboard1().setValoresAlmacen(chasisQty, carroceriaQty, motorQty, wheelsQty, accesoriosQty);
            
        } else {
            this.carroceriaQty -= 2;
            this.chasisQty -= 3;
            this.motorQty -= 4;
            this.wheelsQty -= 6; 
            if(conAcc){
                this.accesoriosQty -= 5;
            }
            dashboard.GlobalUI.getMainUI().getRrDashboard1().setValoresAlmacen(chasisQty, carroceriaQty, motorQty, wheelsQty, accesoriosQty);
        }          
    }
    
    public int getCarsUtility(boolean isLambo){
        int total = 0;
        if(isLambo){
            total = (this.totalCarros * 400000) + (this.totalCarrosAcc * 750000);            
        }else{
            total = (this.totalCarros * 450000) + (this.totalCarrosAcc * 900000);
        }
        return total;
    }
    
}
