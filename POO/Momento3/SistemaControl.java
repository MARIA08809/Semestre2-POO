package Momento3;

public class SistemaControl {
    
    private PuertaAscensor ascensor;            
    private PuertaPiso[] pisos;                 
    private BotonAscensor[] botonesAscensor;    
    private BotonPiso[] botonesSubir;
    private BotonPiso[] botonesBajar;
    private BotonMantenerPuerta botonMantener;

    public SistemaControl(PuertaAscensor ascensor, PuertaPiso[] pisos) {
        this.ascensor = ascensor;
        this.pisos = pisos;

        int n = pisos.length;
        botonesAscensor = new BotonAscensor[n];
        botonesSubir = new BotonPiso[n];
        botonesBajar = new BotonPiso[n];

        for (int i = 0; i < n; i++) {
            botonesAscensor[i] = new BotonAscensor(i + 1);
            if (i != n - 1) {   // el último piso no tiene botón de subir
                botonesSubir[i] = new BotonPiso(i + 1, PuertaPiso.SUBIENDO);
            }
            if (i != 0) {       // el primer piso no tiene botón de bajar
                botonesBajar[i] = new BotonPiso(i + 1, PuertaPiso.BAJANDO);
            }
        }
        botonMantener = new BotonMantenerPuerta(5);
    }

    private void apagarBotones(int piso) {
        botonesAscensor[piso - 1].apagar();
        if (botonesSubir[piso - 1] != null) {
            botonesSubir[piso - 1].apagar();
        }
        if (botonesBajar[piso - 1] != null) {
            botonesBajar[piso - 1].apagar();
        }
    }

    public void despachar(int piso, int direccion) {
        pisos[piso - 1].solicitarAscensor(direccion);
        ascensor.agregarSolicitud(piso);
    }

    public void pulsarBotonAscensor(int piso) {
        botonesAscensor[piso - 1].setPresionado(true);
        System.out.println("Botón del ascensor: piso " + piso);
        ascensor.agregarSolicitud(piso);
    }

    public void pulsarMantenerPuerta() {
        botonMantener.setPresionado(true);
        System.out.println("Mantener puerta abierta");
        ascensor.mantenerAbierta();
    }

    public void pulsarBotonPiso(int piso, int direccion) {
        BotonPiso boton;
        if (direccion == PuertaPiso.SUBIENDO) {
            boton = botonesSubir[piso - 1];
        } else {
            boton = botonesBajar[piso - 1];
        }

        if (boton == null) {
            System.out.println("El piso " + piso + " no tiene botón de " + PuertaPiso.DIRECCIONES[direccion]);
            return;
        }
        boton.setPresionado(true);
        System.out.println("Botón del piso " + piso + ": " + PuertaPiso.DIRECCIONES[direccion]);
        despachar(piso, direccion);
    }

    public void atenderSolicitud() {
        while (ascensor.hayPendientes()) {
            int antes = ascensor.getPisoActual();
            ascensor.mover();
            int ahora = ascensor.getPisoActual();
            if (ahora == antes) {
                break;   // no pudo avanzar (obstáculo en la puerta)
            }
            pisos[antes - 1].cerrar();
            if (ascensor.getEstadoAscensor() == PuertaAscensor.DETENIDO) {
                pisos[ahora - 1].abrir();
                apagarBotones(ahora);
            }
        }
    }
}