package Momento1y2;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Juan Perez", "1005123456");

        Foto[] foto1 =  new Foto[] { new Foto("vacaciones.jpg") };
        Impresion impresion1 = new Impresion(5, 1000, "Color", foto1[0]);
        Camara camara1 = new Camara(2, 1200000, "Canon", "EOS 250D");

        Producto[] productos = { impresion1, camara1 };
        Pedido pedido1 = new Pedido(cliente1, productos[0], "19/10/2026");

    
        System.out.println("Formas de pago:");
        pedido1.mostrarFormasPago();
        pedido1.elegirFormaPago(2);

        System.out.println("Cliente: " + pedido1.getCliente());
        System.out.println("Fecha: " + pedido1.getFecha());
        System.out.println("Forma de pago: " + pedido1.getFormaPagoElegida());
        

        System.out.println(pedido1.getProducto());

        double total = pedido1.getProducto().calcularCosto();

        System.out.println("TOTAL A PAGAR: " + total);
        System.out.println("Pago con: " + pedido1.getFormaPagoElegida());
    }
}