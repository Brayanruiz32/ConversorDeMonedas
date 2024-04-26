package com.conversor;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Logica {

    private double resultado;

    private double cambio;

    private String sufijo;

    private String prefijo;

    private boolean operacionDivision = false;

    private Scanner entrada = new Scanner(System.in);

    public String logicaPrincipal() {
        System.out.println("Ingrese la cantidad a convertir");
        double dinero = Double.parseDouble(entrada.nextLine());
        if (operacionDivision) {
            resultado = dinero / cambio;
        } else {
            resultado = dinero * cambio;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        String resultadorFormateado = df.format(resultado);
        return "El valor de " + dinero + " [" + prefijo + "] corresponde al valor final de =>>> "
                + resultadorFormateado + " [" + sufijo + "] convertido el "+ LocalDateTime.now();
    }

    public boolean verificador(Moneda miMoneda, int opcion) {
        switch (opcion) {
            case 1:
                cambio = miMoneda.getConversiones("EUR");
                denominaciones("EUR", "PEN");
                return true;
            case 2:
                cambio = miMoneda.getConversiones("EUR");
                denominaciones("PEN", "EUR", true);
                return true;
            case 3:
                cambio = miMoneda.getConversiones("USD");
                denominaciones("USD", "PEN");
                return true;
            case 4:
                cambio = miMoneda.getConversiones("USD");
                denominaciones("PEN", "USD", true);
                return true;
            case 5:
                cambio = miMoneda.getConversiones("GBP");
                denominaciones("GBP", "PEN");
                return true;
            case 6:
                cambio = miMoneda.getConversiones("GBP");
                denominaciones("PEN", "GBP", true);
                return true;
            case 7:
                return true;
            default:
                return false;
        }
    }

    public void denominaciones(String sufijo, String prefijo, boolean operacionDivision) {
        this.sufijo = sufijo;
        this.prefijo = prefijo;
        this.operacionDivision = operacionDivision;
    }

    public void denominaciones(String sufijo, String prefijo) {
        this.sufijo = sufijo;
        this.prefijo = prefijo;

    }

    public void menu() {
        System.out.println(
                "1) Nuevo Sol >>>>>> Euros \n2) Euros >>>>>>> Nuevo Sol\n3) Nuevo Sol >>>>>> Dolares Estadounidenses\n4) Dolares Estadounidenses >>>> Nuevo Sol"
                        + "\n5) Nuevo Sol >>>>>> Libra Esterlina\n6) Libra Esterlina >>>>>>> Nuevo Sol\n7 Mostrar historial de conversiones \n8 Salir");
        System.out.println("Escoja una opcion del menu en pantalla");
    }

}
