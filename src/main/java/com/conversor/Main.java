package com.conversor;

import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entrada = new Scanner(System.in);
        Api miApi = new Api("PEN", "95bcabf0d61583b94f947250");
        String json = miApi.peticion();
        Gson gson = new Gson();
        MonedaRecord respuesta = gson.fromJson(json, MonedaRecord.class);
        Moneda miMoneda = new Moneda(respuesta);
        System.out.println("Bienvenido a mi conversor de moneda :]");
        boolean continuar = true;
        while (continuar) {
            Logica miLogica = new Logica();
            miLogica.menu();
            int opcion = Integer.parseInt(entrada.nextLine());
            if (miLogica.verificador(miMoneda, opcion) && opcion != 7) {
                miMoneda.historial(miLogica.logicaPrincipal());
            } else if (opcion == 7) {
                for (String elemento : miMoneda.mostrarHistorial()) {
                    System.out.println(elemento);
                }
            } else {
                continuar = false;
            }
        }
        entrada.close();
        System.out.println("Gracias por utilizar el conversor :D");
    }
}