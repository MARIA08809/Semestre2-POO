package Momento3;

public class PuertaAscensor extends Puerta {

    public static final String[] ESTADOS = {"DETENIDO", "EN_MOVIMIENTO"};
    public static final int DETENIDO = 0;
    public static final int EN_MOVIMIENTO = 1;


    public static final String[] DIRECCIONES = {"SUBIENDO", "BAJANDO"};
    public static final int SUBIENDO = 0;
    public static final int BAJANDO = 1;

    private int pisoActual;
    private int estado;            
    private int direccion;         
    private boolean[] solicitudes; 

    public PuertaAscensor(int pisoActual, int totalPisos) {
        super(false, CERRADA);
        this.pisoActual = pisoActual;
        this.estado = DETENIDO;
        this.direccion = SUBIENDO;
        this.solicitudes = new boolean[totalPisos + 1];
    }

    
    public int getPisoActual() {
        return pisoActual;
    }

    public int getEstadoAscensor() {
        return estado;
    }

    public void cambiarDireccion() {
        if (direccion == SUBIENDO) {
            direccion = BAJANDO;
        } else {
            direccion = SUBIENDO;
        }
    }

    
    // ¿Hay alguna solicitud en cualquier piso?
    public boolean hayPendientes() {
        for (int i = 1; i < solicitudes.length; i++) {
            if (solicitudes[i]) {
                return true;
            }
        }
        return false;
    }

    // ¿Hay alguna solicitud en los pisos de arriba?
    private boolean hayArriba() {
        for (int i = pisoActual + 1; i < solicitudes.length; i++) {
            if (solicitudes[i]) {
                return true;
            }
        }
        return false;
    }

    // ¿Hay alguna solicitud en los pisos de abajo?
    private boolean hayAbajo() {
        for (int i = pisoActual - 1; i >= 1; i--) {
            if (solicitudes[i]) {
                return true;
            }
        }
        return false;
    }

    public void agregarSolicitud(int piso) {
        if (piso < 1 || piso >= solicitudes.length) {
            System.out.println("Piso " + piso + " no válido");
        } else if (piso == pisoActual) {
            abrir();
        } else {
            solicitudes[piso] = true;
        }
    }

    public void mover() {
        // 1. Si no hay solicitudes, se queda detenido
        if (!hayPendientes()) {
            estado = DETENIDO;
            return;
        }

        // La puerta debe estar cerrada para moverse
        cerrar();
        if (getEstado() != CERRADA) {
            System.out.println("El ascensor no se mueve: puerta abierta");
            return;
        }

        //  Si ya no hay solicitudes en esta dirección, se cambia
        if (direccion == SUBIENDO && !hayArriba()) {
            cambiarDireccion();
        } else if (direccion == BAJANDO && !hayAbajo()) {
            cambiarDireccion();

        }

        // Se mueve un piso
        estado = EN_MOVIMIENTO;
        if (direccion == SUBIENDO) {
            pisoActual++;
        } else {
            pisoActual--;
        }
        System.out.println("Ascensor en piso " + pisoActual + " (" + DIRECCIONES[direccion] + ")");

        //  Si en este piso había una solicitud, se detiene y abre
        if (solicitudes[pisoActual]) {
            solicitudes[pisoActual] = false;
            estado = DETENIDO;
            abrir();
            System.out.println("Ascensor detenido en piso " + pisoActual + " - puerta abierta");
        }
    }
}