package Momento1y2;

public abstract class Producto {
    private int numero;
    private final double valor;   // constante: no cambia

    public Producto(int numero, double valor) {
        this.numero = numero;
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero <= 0) {
            System.out.println("El número del producto debe ser mayor que cero.");
        } else {
            this.numero = numero;
        }
    }

    public double getValor() {
        return valor;
    }

    // costo = numero * valor
    public double calcularCosto() {
        return numero * valor;
    }

    // Solo muestra el costo total
    public void mostrar() {
        System.out.println("Costo total: " + calcularCosto());
    }

    public String toString() {
        return "Producto #" + numero;
    }
}