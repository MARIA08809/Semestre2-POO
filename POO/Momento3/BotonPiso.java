package Momento3;

public class BotonPiso extends Botones {
    private int numeroPiso;
    private int direccion;
    private PuertaPiso[] pisos;
    private PuertaAscensor ascensor;

    public BotonPiso(PuertaPiso[] pisos, PuertaAscensor ascensor) {
        super();
        this.pisos = pisos;
        this.ascensor = ascensor;
    }

    // Usa el piso y la dirección
    @Override
    public void presionar(int piso, int direccion) {
        // el primer piso no tiene botón de bajar y el último no tiene botón de subir
        if ((piso == 1 && direccion == PuertaPiso.BAJANDO)
                || (piso == pisos.length && direccion == PuertaPiso.SUBIENDO)) {
            System.out.println("El piso " + piso + " no tiene botón de " + PuertaPiso.DIRECCIONES[direccion]);
        } else {
            this.numeroPiso = piso;
            this.direccion = direccion;
            encender();
            System.out.println("Botón del piso " + piso + ": " + PuertaPiso.DIRECCIONES[direccion]);
            pisos[piso - 1].solicitarAscensor(direccion);
            ascensor.agregarSolicitud(piso);
        }
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public int getDireccion() {
        return direccion;
    }
}