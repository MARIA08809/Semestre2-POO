package Momento3;

public class BotonAscensor extends Botones {
    private int pisoDestino;
    private PuertaAscensor ascensor;

    public BotonAscensor(PuertaAscensor ascensor) {
        super();
        this.ascensor = ascensor;
    }

    // Usa el piso al que quieren ir
    @Override
    public void presionar(int piso, int direccion) {
        pisoDestino = piso;
        encender();
        System.out.println("Botón del ascensor: piso " + pisoDestino);
        ascensor.agregarSolicitud(pisoDestino);
    }

    public int getPisoDestino() {
        return pisoDestino;
    }
}