package Momento3;

public class SistemaControl {
    // ---- Atributos ----
    private PuertaAscensor ascensor;            // Agregación
    private PuertaPiso[] pisos;                 // Agregación

    private BotonAscensor[] botonesAscensor;    // Composición: el sistema crea sus botones
    private BotonPiso[] botonesSubir;
    private BotonPiso[] botonesBajar;
    private BotonMantenerPuerta botonMantener;
    private Alarma alarma;                  // Composición

    // ---- Constructor ----
    public SistemaControl(PuertaAscensor ascensor, PuertaPiso[] pisos) {
        this.ascensor = ascensor;
        this.pisos = pisos;

        int n = pisos.length;
        botonesAscensor = new BotonAscensor[n];
        botonesSubir = new BotonPiso[n];
        botonesBajar = new BotonPiso[n];

        for (int i = 0; i < n; i++) {
            botonesAscensor[i] = new BotonAscensor(i + 1);
            botonesSubir[i] = new BotonPiso(i + 1, PuertaPiso.SUBIENDO);
            botonesBajar[i] = new BotonPiso(i + 1, PuertaPiso.BAJANDO);
        }
        botonesBajar[0] = null;       // el primer piso no baja
        botonesSubir[n - 1] = null;   // el último piso no sube
        botonMantener = new BotonMantenerPuerta(5);
        alarma = new Alarma();
    }

    // ---- Métodos simples ----
    private void apagarBotones(int piso) {
        apagarSiExiste(botonesAscensor[piso - 1]);
        apagarSiExiste(botonesSubir[piso - 1]);
        apagarSiExiste(botonesBajar[piso - 1]);
    }

    private void apagarSiExiste(BotonPiso boton) {
        if (boton != null) {
            boton.apagar();
        }
    }

    private void apagarSiExiste(BotonAscensor boton) {
        if (boton != null) {
            boton.apagar();
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

    public void activarAlarma() {
        alarma.activar();
    }

    public void desactivarAlarma() {
        alarma.desactivar();
    }

    // ---- Método con ciclo y condiciones ----
    public void atenderSolicitud() {
        for (int i = 0; i < pisos.length * 2; i++) {
            if (ascensor.hayPendientes() && !alarma.isActivada()) {
                int antes = ascensor.getPisoActual();
                ascensor.mover();
                pisos[antes - 1].cerrar();

                if (ascensor.getEstadoAscensor() == PuertaAscensor.DETENIDO) {
                    int ahora = ascensor.getPisoActual();
                    pisos[ahora - 1].abrir();
                    apagarBotones(ahora);
                }
            }
        }
    }
}