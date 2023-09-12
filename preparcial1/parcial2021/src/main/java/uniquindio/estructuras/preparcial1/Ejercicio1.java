package uniquindio.estructuras.preparcial1;


import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        Piso piso = new Piso();
        String [][] mapa = piso.getPiso();
        List<String[][]> soluciones = new ArrayList<>();
        System.out.println("Inicio de recorrido");
        iniciarRecorrido(mapa,soluciones);
        for (String[][] solucion : soluciones) {
            imprimirSolucion(solucion);
            System.out.println("------");
        }
    }

    private static void iniciarRecorrido(String[][] piso, List<String[][]> soluciones) {

        recorrerPiso(piso,0,0,soluciones);
//        imprimirSolucion(piso);
    }

    private static void recorrerPiso(String[][] piso, int i, int j, List<String[][]> soluciones) {
        if(i == 6 && j == 6 ) {
            String[][] copiaPiso = new String[piso.length][piso[0].length];
            for (int k = 0; k < piso.length; k++) {
                copiaPiso[k] = piso[k].clone();
            }
            copiaPiso[i][j] = "B"; // Marcar el camino
            soluciones.add(copiaPiso);
            return;
        }
        if(i >= 0 && i <= piso.length - 1 && j >= 0 && j <= piso[0].length - 1){
            if(piso[i][j].equals("1") || piso[i][j].equals("V") || piso[i][j].equals("B")){
                return;
            }
            piso[i][j] = "V";
            recorrerPiso(piso,i+1,j, soluciones);
            recorrerPiso(piso,i,j-1, soluciones);
            recorrerPiso(piso,i-1,j, soluciones);
            recorrerPiso(piso,i,j+1, soluciones);
            piso[i][j] = "";        }
    }

    private static void imprimirSolucion(String[][] piso) {
        StringBuilder cad = new StringBuilder();
        for (String[] strings : piso) {
            for (int j = 0; j < piso[0].length; j++) {
                cad.append(strings[j]).append("\t");
            }
            cad.append("\n");
        }
        System.out.println(cad);
    }
}
class Piso {
    String [][] piso;
    public Piso(){
        this.piso = new String[][]{
                {"", "", "", "", "", "1", "", ""},
                {"", "1", "1", "", "1", "1", "", "1"},
                {"", "", "1", "", "", "", "", ""},
                {"1", "", "", "", "", "1", "1", ""},
                {"1", "", "1", "1", "", "1", "1", ""},
                {"","","","","","","",""},
                {"1", "", "1", "", "1", "1", "", "1"}
        };
    }

    public String[][] getPiso() {
        return piso;
    }
}