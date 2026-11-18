package Momento3;

public class BotonAscensor extends Botones {
    private int pisoDestino;

    public BotonAscensor(int pisoDestino) {
        super();
        this.pisoDestino = pisoDestino;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }
}