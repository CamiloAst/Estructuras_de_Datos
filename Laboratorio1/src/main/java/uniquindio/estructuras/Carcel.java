
package uniquindio.estructuras;

import java.util.List;

public class Carcel {

    private List<Piso> listaPisos;

    public Carcel(List<Piso> listaPisos) {
        super();
        this.listaPisos = listaPisos;
    }

    public static void main(String[] args) {

        char[][] carcel = {
                { ' ', 'P', 'X', ' ', 'P', 'P', ' ', 'P'},
                { ' ', 'P', 'P', ' ', 'P', 'P', ' ', 'P'},
                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                { 'P', ' ', 'P', 'P', ' ', 'P', 'P', ' '},
                { 'P', ' ', 'X', 'P', ' ', 'P', 'P', ' '},
                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                { 'P', 'X', 'P', ' ', 'P', 'P', ' ', 'P'},
        };

        resolver(0,0,carcel);

    }


    public static void resolver(int x, int y, char[][] carcel){

        if(contarPresos(x, y, carcel,0) < 1){
            System.out.println("Faltan presos");
        }else{
            System.out.println("No faltan presos");
        }
    }


    public static int contarPresos(int x, int y, char[][] carcel, int c){
        if(x < carcel.length && x >= 0 && y >= 0 && y < carcel[0].length){

            if (carcel[x][y] == 'P'){
                c += 1;
                carcel[x][y] = 'X';
                return c;
            }

            if (carcel[x][y] == 'X' || carcel[x][y] == '*') {
                return 0;
            }

            carcel[x][y] = '*';

            c += contarPresos(x, y + 1, carcel, 0);


            c += contarPresos(x + 1, y, carcel, 0);

            c += contarPresos(x - 1, y, carcel, 0);

            c += contarPresos(x, y - 1, carcel, 0);

            carcel[x][y] = ' ';
            return c;

        }
        return 0;
    }

}
