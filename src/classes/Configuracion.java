/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Configuracion {

    private Map<String, String> parametros;

    public Configuracion() {
        parametros = new HashMap<>();
    }

    public void leerConfiguracion(String archivo) {
        try {
            File file = new File(archivo);
            System.out.println("Ruta del archivo: " + file.getAbsolutePath());

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    linea = linea.trim();
                    if (!linea.isEmpty()) {
                        String[] partes = linea.split("=");
                        if (partes.length == 2) {
                            String clave = partes[0].trim();
                            String valor = partes[1].trim();
                            parametros.put(clave, valor);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String obtenerParametro(String clave) {
        return parametros.get(clave);
    }

    public void imprimirConfiguracion() {
        System.out.println("Configuración:");
        for (Map.Entry<String, String> entry : parametros.entrySet()) {
            String clave = entry.getKey();
            String valor = entry.getValue();
            System.out.println(clave + ": " + valor);
        }
    }
}

