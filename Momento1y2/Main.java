package Momento1y2;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("1005123456", "Juan Perez");

        Foto foto =  new Foto("vacaciones.jpg");
        Impresion impresion = new Impresion(5, 1000, "Color", foto);
        Camara camara = new Camara(2, 1200000, "Canon", "EOS 250D");

        Producto[] productos = { impresion, camara };
        Pedido pedido = new Pedido(cliente, productos[0], "19/10/2026");

        // Se muestran las 3 formas de pago y se escoge una (1, 2 o 3)
        System.out.println("Formas de pago:");
        pedido.mostrarFormasPago();
        pedido.elegirFormaPago(2);

        System.out.println();
        System.out.println("Cliente: " + pedido.getCliente().getNombre());
        System.out.println("Fecha: " + pedido.getFecha());
        System.out.println("Forma de pago: " + pedido.getFormaPagoElegida());
        System.out.println();

        double total = 0;
        for (Producto p : new Producto[]{pedido.getProducto()}) {
            // Se revisa si el producto es una Impresion o una Camara
            String tipo = "";
            if (p instanceof Impresion) {
                tipo = "Impresion";
            } else if (p instanceof Camara) {
                tipo = "Camara";
            }

            System.out.println("Producto: " + tipo);
            System.out.println("Cantidad (numero): " + p.getNumero());
            System.out.println("Valor: " + p.getValor());
            System.out.println("Valor a pagar: " + p.getNumero() + " x " + p.getValor()
                    + " = " + p.calcularCosto());
            System.out.println();

            total = total + p.calcularCosto();
        }

        System.out.println("TOTAL A PAGAR: " + total);
        System.out.println("Pago con: " + pedido.getFormaPagoElegida());
    }
}