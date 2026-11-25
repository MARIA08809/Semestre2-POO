package Momento3;

public class SistemaControl {
    
    public static final int BOTON_ASCENSOR = 0;
    public static final int BOTON_PISO = 1;
    public static final int BOTON_MANTENER_PUERTA = 2;


    private PuertaAscensor ascensor;            
    private PuertaPiso[] pisos;                 

    private Botones[] botones;                 
    private Alarma alarma;                     

    public SistemaControl(PuertaAscensor ascensor, PuertaPiso[] pisos) {
        this.ascensor = ascensor;
        this.pisos = pisos;

        botones = new Botones[3];
        botones[BOTON_ASCENSOR] = new BotonAscensor(ascensor);
        botones[BOTON_PISO] = new BotonPiso(pisos, ascensor);
        botones[BOTON_MANTENER_PUERTA] = new BotonMantenerPuerta(5, ascensor);

        alarma = new Alarma();
    }

    //  se llama a presionar y cada botón tiene su comportamiento específico
    public void pulsarBotonAscensor(int piso) {
        botones[BOTON_ASCENSOR].presionar(piso, 0);        
    }

    public void pulsarBotonPiso(int piso, int direccion) {
        botones[BOTON_PISO].presionar(piso, direccion);
    }

    public void pulsarMantenerPuerta() {
        botones[BOTON_MANTENER_PUERTA].presionar(0, 0);    
    }

    private void apagarBotones() {
        for (int i = 0; i < botones.length; i++) {
            botones[i].apagar();
        }
    }

    public void activarAlarma() {
        alarma.activar();
    }

    public void desactivarAlarma() {
        alarma.desactivar();
    }

    public void atenderSolicitud() {
        // cada vuelta mueve el ascensor un piso
        for (int i = 0; i < pisos.length * 2; i++) {
            if (ascensor.hayPendientes() && !alarma.isActivada()) {
                ascensor.mover();
            }
        }

        if (!ascensor.hayPendientes()) {   // ya no queda nada por atender
            apagarBotones();
        }
    }
}