
public class Cliente {
    private String nombre;
    private String cedula;

    public Cliente(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
                if (nombre==("")) {
            System.out.println("El nombre no puede estar vacio.");
        } else {
            this.nombre = nombre;
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
                if (cedula==("")) {
            System.out.println("La cédula no puede estar vacía.");
        } else {
            this.cedula = cedula;
        }
    }
    public String toString() {
        return "Cliente{cedula='" + cedula + "', nombre='" + nombre + "'}";
    }
}
