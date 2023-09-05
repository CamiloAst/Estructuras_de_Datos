package lab.modelo;


public class Carcel {
    private Pasillo[][] mapa1;
    private final int y = 0, x = 4;
    private int posx, posy;
    private Piso piso = new Piso(14, 16, 0, 0, 0);
    private volatile Boolean pausar = true ;
    private String image = " ";
    private int xC, yC;

    public Carcel() {
        super();
        mapa1 = new Pasillo[][]{
                {new Pasillo(), new Celda(2,true), new Celda(3,false), new Celda(4,true), new Celda(5,false), new Pasillo()},
                {new Celda(6,true), new Pasillo(), new Pasillo(), new Pasillo(), new Celda(7,false), new Pasillo()},
                {new Celda(8,true), new Pasillo(), new Celda(9,false), new Pasillo(), new Celda(10,true), new Pasillo()},
                {new Celda(11,true), new Pasillo(), new Celda(12,false), new Pasillo(), new Pasillo(), new Pasillo()},
                {new Pasillo(), new Pasillo(), new Celda(13,true), new Celda(14,true), new Pasillo(), new Pasillo()}};
        piso.setMapa(mapa1);
    }
    public synchronized void pausarRecorrido(){
        pausar = true;
    }
    public synchronized void continuarRecorrido(){
       pausar = false;
       notify();
    }

    public void iniciarRecorrido() {
        recorrerPiso(x, y, mapa1);
    }
    public synchronized void recorrerPiso(int x, int y, Pasillo[][] mapa) {
        image = " ";
        if (x < 0 || y < 0 || x > 4 || y > 5 || mapa[x][y].isRecorrido()) {
            return;
        }
        if(mapa[x][y] instanceof Celda && ((Celda)mapa[x][y]).isCheck()){
            return;
        }
        if (mapa[x][y] instanceof Celda && !((Celda)mapa[x][y]).isCheck()) {
            if (((Celda) mapa[x][y]).isOcupada()) {
                System.out.println("La celda " + ((Celda) mapa[x][y]).getNumero() + " esta ocupada");
                image = ("/images/celdaOcupada.png");
                xC=x;
                yC=y;
//                guardarPrisionero(((Celda) mapa[x][y]).getPrisionero());
                ((Celda) mapa[x][y]).setCheck(true);
                pausarRecorrido();
                while(pausar){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("La celda " + ((Celda) mapa[x][y]).getNumero() + " esta libre");
                image = ("/images/celdaLibre.png");
                xC=x;
                yC=y;
                piso.setCantidadCeldasLibres(piso.getCantidadCeldasLibres() + 1);
                ((Celda) mapa[x][y]).setCheck(true);
                pausarRecorrido();
                while(pausar){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else if (mapa[x][y] != null){
            posx = x;
            posy = y;
            if (!mapa[x][y].isRecorrido()) {
                System.out.println("El pasillo esta libre");
                mapa[x][y].setRecorrido(true);
            }
            pausarRecorrido();
            while(pausar){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            recorrerPiso(x-1, y, mapa);
            posx = x;
            posy = y;
            pausarRecorrido();
            while(pausar){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            recorrerPiso(x, y+1, mapa);
            posx = x;
            posy = y;
            pausarRecorrido();
            while(pausar){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            recorrerPiso(x+1, y, mapa);
            posx = x;
            posy = y;
            pausarRecorrido();
            while(pausar){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            recorrerPiso(x, y-1, mapa);
            posx = x;
            posy = y;
            pausarRecorrido();
            while(pausar){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            return;
        }
    }


//    private void guardarPrisionero(Prisionero prisionero){
//        piso.getPrisioneros().add(prisionero);
//        piso.setCantidadCeldasOcupadas(piso.getCantidadCeldasOcupadas() + 1);
//    }
    public int getPosX(){
        return posx;
    }
    public int getPosY(){
        return posy;
    }
    public int getXCelda() {
        return xC;
    }
    public int getYCelda() {
        return yC;
    }
    public void setPausar(Boolean cm){
        pausar = cm;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public Celda getCelda(int x, int y){
        return (Celda) mapa1[x][y];
    }
}