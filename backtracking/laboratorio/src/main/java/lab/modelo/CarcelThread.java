package lab.modelo;

public class CarcelThread extends Thread{
    private Carcel carcel;

    public CarcelThread(Carcel carcel) {
        this.carcel = carcel;
    }

    @Override
    public void run(){
        carcel.iniciarRecorrido();
    }
}
