/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productores;

/**
 *
 * @author mannith
 */
import classes.Main;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class DirectorPlanta extends Thread {
    private int diasRestantes;
    private int saldo;
    private Gerente gerente;
    private int faltas;

    public DirectorPlanta(int diasRestantes, int saldo) {
        this.diasRestantes = diasRestantes;
        this.saldo = saldo;
        this.faltas = 0;
    }
    
    
    public int getFaltas() {
        return faltas;
    }

    public int calcularSaldoFinalGerente() {
        int descuentoPorFalta = 50; // Monto de descuento por cada falta
        int sueldoGerente = 14600;
        int saldoFinalGerente = sueldoGerente - (faltas * descuentoPorFalta);
        return saldoFinalGerente;
    }
    
    @Override
    public void run() {
        Random random = new Random(); // Generador de números aleatorios
        while (true) {
            if (diasRestantes == 0) {
                // Enviar vehículos al concesionario
                System.out.println("Enviando vehículos al concesionario...");
                // Simulamos el tiempo que toma enviar los vehículos
                try {
                    Thread.sleep(24 * 60 * 60 * 1000); // 24 horas
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Actualizar saldo y reiniciar contador
//                saldo += calcularGananciaEnviada();
            } else {
                // Realizar tareas administrativas
                System.out.println("Director realizando tareas administrativas...");
                // Verificar lo que está haciendo el gerente
                try {
                int randomHour = random.nextInt(24); // Generar una hora aleatoria del día
                int randomMin = random.nextInt(60);
                for (int i = 0; i < 24; i++) { // Simulando cada hora del día
                    if (i == randomHour) {
                        for(int j=0; j<60;j++){
                            if(j==randomMin){
                                verificarActividadGerente();
                            }
                            Thread.sleep(Main.gerente.getDayDurationInMs() / (24*60));
                        }
                    }
                    Thread.sleep(Main.gerente.getDayDurationInMs() / 24); // Espera una hora en tiempo de simulación
                }
                        } catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
        }
    }

    private int calcularGananciaEnviada() {
        // Cálculo de la ganancia enviada
        return 0;
    }

    private int reiniciarContador() {
        // Reiniciar el contador de días restantes
        return 0;
    }

    public void verificarActividadGerente() {
        System.out.println("Director supervisando al gerente");

        if (Main.gerente.estaViendoCarreras()) {
            // El gerente está viendo carreras
            System.out.println("Falta al gerente por ver carreras. Se descontarán $50 de su sueldo.");
            faltas++;
//            Main.gerente.dejarDeVerCarreras(); // El gerente deja de ver carreras
        } else {
            // El gerente está trabajando
            System.out.println("El gerente está trabajando.");
        }
    }
}