package Momento1y2;

 public class Impresion extends Producto {
    private String color;
    private Foto foto;

    public Impresion(int numero, double valor, String color, Foto foto) {
        super(numero, valor);
        this.color = color;
        this.foto = foto;
    }

    public String getColor() { 
        return color; }
    public void setColor(String color) { 
        this.color = color; }
    public Foto getFoto() { 
        return foto; }
    public void setFoto(Foto foto) { 
        this.foto = foto; }
        
    @Override
    public String getTipo() {
        return "Impresion";
    }

    public void print() {
        System.out.println("Imprimiendo foto " + foto.getFichero() + " en color: " + color);
    }
}
