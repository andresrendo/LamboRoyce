/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Configuracion {

    private Map<String, Integer> parametros;

    public Configuracion() {
        parametros = new HashMap<>();
    }

    public void leerConfiguracion(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    String[] partes = linea.split("=");
                    if (partes.length == 2) {
                        String clave = partes[0].trim();
                        int valor = Integer.parseInt(partes[1].trim());
                        parametros.put(clave, valor);
                        // con el valor(cantidad empleados) los guardo en el array de acnt empleados por depto
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static int[] leerDatosIniciales() {
        String archivo = "src//classes//deadlineAndDuration.txt";
        String text = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                text += (linea+"\n");
            }                                   
        } catch (IOException e) {
            text = "";
            e.printStackTrace();
        }
        String[] split = text.split(",");
        int [] values = new int[2];

        values[0] = Integer.parseInt(split[0].replace("\n", ""));
        values[1] = Integer.parseInt(split[1].replace("\n", ""));       
        return values;
    }

    public void actualizarConfiguracion(String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, Integer> entry : parametros.entrySet()) {
                String clave = entry.getKey();
                int valor = entry.getValue();
                bw.write(clave + "=" + valor);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int obtenerParametro(String clave) {
        return parametros.get(clave);
    }

    public void setParametro(String clave, int valor) {
        parametros.put(clave, valor);
    }

    public void sumarParametro(String clave, int cantidad) {
        int valorActual = obtenerParametro(clave);
        int nuevoValor = valorActual + cantidad;
        setParametro(clave, nuevoValor);
    }

    public void restarParametro(String clave, int cantidad) {
        int valorActual = obtenerParametro(clave);
        int nuevoValor = valorActual - cantidad;
        setParametro(clave, nuevoValor);
    }

    public void imprimirConfiguracion() {
        System.out.println("Configuración:");
        for (Map.Entry<String, Integer> entry : parametros.entrySet()) {
            String clave = entry.getKey();
            int valor = entry.getValue();
            System.out.println(clave + ": " + valor);
        }
    }
}

