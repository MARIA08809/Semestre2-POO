public class Camara extends Producto {
    private String marca;
    private String modelo;

    public Camara(int numero, double valor, String marca, String modelo) {
        super(numero, valor);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    @Override
    public String getTipo() {
        return "Camara";
    }

    @Override
    public String toString() {
        return super.toString()
             + ", Marca: " + marca 
             + ", Modelo: " + modelo;
    }
    
}