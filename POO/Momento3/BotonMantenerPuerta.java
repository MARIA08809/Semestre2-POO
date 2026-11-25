package Momento3;

public class BotonMantenerPuerta extends Botones {
    private int tiempoEspera;
    private PuertaAscensor ascensor;

    public BotonMantenerPuerta(int tiempoEspera, PuertaAscensor ascensor) {
        super();
        this.tiempoEspera = tiempoEspera;
        this.ascensor = ascensor;
    }

    // No usa ni el piso ni la dirección
    @Override
    public void presionar(int piso, int direccion) {
        encender();
        System.out.println("Mantener puerta abierta (" + tiempoEspera + " seg)");
        ascensor.mantenerAbierta();
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }
}