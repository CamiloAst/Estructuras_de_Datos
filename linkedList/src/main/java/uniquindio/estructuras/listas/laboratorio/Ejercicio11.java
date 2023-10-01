package uniquindio.estructuras.listas.laboratorio;

import uniquindio.estructuras.listas.clases.ListaSimple;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio11 {
    public static void main(String[] args) {
        ListaSimple<int[]> listaPolinomios = new ListaSimple<int[]>();
        String[] terminos;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el polinomio a evaluar en el siguiente formato: ax^2+bx^1+cx^0...dx^n");
        String polinomio = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\s*([-+]?\\d*x\\^\\d+|[-+]?\\d+)\\s*");
        Matcher matcher = pattern.matcher(polinomio);



       listaPolinomios = separarTerminos(polinomio, pattern, matcher, listaPolinomios);

        float[][] resultado = evaluarPolinomio(listaPolinomios);

        for (int i = 0; i < resultado.length; i++) {
            System.out.print("f("+i*0.5f+") = ");
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.print(resultado[i][j]+" ");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static ListaSimple<int[]> separarTerminos(String polinomio, Pattern pattern, Matcher matcher, ListaSimple<int[]> listaPolinomios) {
        while(matcher.find()) {
            String termino = matcher.group(1).trim();
            termino = termino.trim();
            int[] polinomioArray = new int[2];
            if(termino.contains("x^")){
                String[] terminoArray = termino.split("x\\^");
                polinomioArray[0] = Integer.parseInt(terminoArray[0]);
                polinomioArray[1] = Integer.parseInt(terminoArray[1]);
            }else if(termino.contains("x")){
                String[] terminoArray = termino.split("x");
                polinomioArray[0] = Integer.parseInt(terminoArray[0]);
                polinomioArray[1] = 1;
            } else {
                polinomioArray[0] = Integer.parseInt(termino);
                polinomioArray[1] = 0;
            }
            listaPolinomios.agregarNodo(polinomioArray);

        }
        return listaPolinomios;
    }

    private static float[][] evaluarPolinomio(ListaSimple<int[]> listaPolinomios) {
        float[][] resultado = new float[11][listaPolinomios.getSize()];
        int contador = 0;
        float num = 0.0f;

        while(num <= 5){
            for (int i = 0; i < listaPolinomios.getSize(); i++) {
                int[] polinomio = listaPolinomios.obtenerValorNodo(i);
                resultado[contador][i] = (float) (polinomio[0]*Math.pow(num,polinomio[1]));
            }
            contador++;
            num+=0.5f;
        }
        return resultado;
    }
}
