package com.imprenta.dominio;

import java.util.ArrayList;
import java.util.Date;

public class OrdenTrabajo {

    private final int id_ot;
    private static int contador_ot;
    private Cliente cliente; //obj Cliente
    private String fecha; //OJO! cambiar a tipo Date
    private int cantidad;
    private ArrayList<Producto> producto; //array de obj Producto
    //private Producto productos[];//array de todos los productos (obj produtos)
    private static int contador_prod;//para recorrer el array de productos

    public OrdenTrabajo() {
        OrdenTrabajo.contador_prod = 0;//el que le mando en el constructor
        this.id_ot = ++OrdenTrabajo.contador_ot;
        //this.productos = new Producto[25];//fuerzo una dimension
    }

    public OrdenTrabajo(Cliente cliente, String fecha) {
        this();
        this.cliente = cliente;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.producto = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /*
    public static int getContador_ot() {
        return contador_ot;
    }

    public static void setContador_ot(int contador_ot) {
        OrdenTrabajo.contador_ot = contador_ot;
    }
     */
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setProducto(ArrayList<Producto> producto) {
        this.producto = producto;
    }

    /* public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }*/
    //METODOS
    /*
    //LO AGREGO EN EL CONSTRUCTOR
    public void agregarCliente(Cliente cliente) { 
        this.cliente = cliente;
    }
     */
    public double calcularPliegos(Producto producto) {
        double pliegos = 1;
        //for (int i = 0; i < productos.length; i++) {
        for (int i = 0; i < this.contador_prod; i++) {
            switch (producto.getMedida()) {
                case A3:
                    pliegos = 1 * cantidad;
                    break;
                case A4:
                    pliegos = 2 / cantidad;
                    break;
                case A5:
                    pliegos = 4 / cantidad;
                    break;
                case A6:
                    pliegos = 8 / cantidad;
                    break;
                case TARJETA:
                    pliegos = 20 / cantidad;
                    break;
            }
        }
        return pliegos;
    }

    public void agregarProdutos(Producto producto, int cantidad) {
        this.contador_prod++;
        this.producto.add(producto);
        //producto.add(producto);
        this.cantidad = cantidad;
        /*calcularPliegos(cantidad, medida);//llamada a método
        for (int i = 0; i < this.contador_prod; i++) {
            //Producto[] productos = {producto};
            System.out.println(calcularPliegos(cantidad, medida));
            
        }*/
    }

    public void mostrarOrden() {
        System.out.println("ID OT: " + this.id_ot);
        System.out.println("Cliente: " + this.cliente);
        System.out.println("Cantidad: " + this.cantidad);
        System.out.println("Contador prodctos: " + this.contador_prod);
        /*for (int i = 0; i < contador_prod; i++) {
            System.out.println(this.producto[i]);//NULL!! 
        }*/
    }

    @Override
    public String toString() {
        return "OrdenTrabajo{" + "id_ot=" + id_ot + ", cliente=" + cliente + ", fecha=" + fecha + ", cantidad=" + cantidad + ", producto=" + producto + '}';
    }

}
