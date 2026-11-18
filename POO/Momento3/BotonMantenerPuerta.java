package Momento3;

public class BotonMantenerPuerta extends Botones {
    private int tiempoEspera;

    public BotonMantenerPuerta(int tiempoEspera) {
        super();
        this.tiempoEspera = tiempoEspera;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }
}