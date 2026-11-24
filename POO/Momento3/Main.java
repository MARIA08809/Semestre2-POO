package Momento3;

public class Main {
    public static void main(String[] args) {
        final int TOTAL_PISOS = 5;

        // Se crean los pisos
        PuertaPiso[] pisos = new PuertaPiso[TOTAL_PISOS];
        for (int i = 0; i < pisos.length; i++) {
            pisos[i] = new PuertaPiso(i + 1, false, Puerta.CERRADA);
        }

        // Se crea el ascensor (empieza en el piso 1) y el sistema de control
        PuertaAscensor ascensor = new PuertaAscensor(1, TOTAL_PISOS);
        SistemaControl sistema = new SistemaControl(ascensor, pisos);

        // Dos personas llaman al ascensor desde distintos pisos
        sistema.pulsarBotonPiso(4, PuertaPiso.BAJANDO);
        sistema.pulsarBotonPiso(2, PuertaPiso.SUBIENDO);
        sistema.atenderSolicitud();

        // Alguien dentro elige el piso 5 y mantiene la puerta abierta
        sistema.pulsarBotonAscensor(5);
        sistema.pulsarMantenerPuerta();
        sistema.atenderSolicitud();

        // Prueba de la alarma: con la alarma sonando el ascensor no se mueve
        System.out.println("--- Alarma ---");
        sistema.activarAlarma();
        sistema.pulsarBotonAscensor(1);
        sistema.atenderSolicitud();        // no se mueve

        sistema.desactivarAlarma();
        sistema.atenderSolicitud();        // ahora sí baja al piso 1
    }
}
