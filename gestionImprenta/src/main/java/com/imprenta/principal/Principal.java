package com.imprenta.principal;

//import com.imprenta.dominio.*;
import com.imprenta.dominio.Producto;
import com.imprenta.dominio.SeleeccionarEnm;
import com.imprenta.dominio.TamanioPapel;
import com.imprenta.dominio.TipoEncuadernado;
import com.imprenta.dominio.TipoPapel;
import com.imprenta.dominio.TipoPlastificado;
import com.imprenta.negocio.*;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        menuProductos();
        //menuClientes();
    }

    public static void menuClientes() {
        ICatalogoProductos datosClientes = new CatalogoProductosImp();
        int opcion;
        System.out.println("----------------------------------\n"
                + "           MENU CLIENTES"
                + "\n----------------------------------\n"
                + "1. Crear Archivo de clientes\n"
                + "2. Agregar cliente\n"
                + "3. Listar clientes\n"
                + "4. Buscar cliente\n"
                + "7. Eliminar cliente\n"
                + "0. Salir\n"
                + "Introduzca una opcion:"
        );
        do {
            Scanner sn = new Scanner(System.in);
            opcion = sn.nextInt();
            switch (opcion) {

                case 1:
                    datosClientes.iniciarArchivo(/*"clientes.txt"*/);
                    System.out.println("\n¿Que más quieres hacer?");
                    break;
                case 2:
                    // datosClientes.agregar();
                    System.out.println("\n¿Que más quieres hacer?");
                    break;
                case 3:
                    datosClientes.listar(/*"clientes.txt"*/);
                    System.out.println("\n¿Que más quieres hacer?");
                    break;
                case 4:
                    datosClientes.buscar(/*"clientes.txt", */"Giga gaming 3060");
                    System.out.println("\n¿Que más quieres hacer?");
                    break;
                case 7:
                    datosClientes.borrar(/*"clientes.txt", */"Giga gaming 3060");
                    System.out.println("\n¿Que más quieres hacer?");
                    break;
                case 0:
                    System.out.println("Gracias!");
                    break;
                default:
                    System.out.println("Valor erroneo");
            }
        } while (opcion != 0);
    }

    public static void menuProductos() {

        ICatalogoProductos datosProductos = new CatalogoProductosImp();
        int opcion;

        System.out.print("\t----------------------------------\n"
                + "\t            MENU PRODUCTOS"
                + " \n\t----------------------------------\n"
                + "\t 1. Crear Archivo de productos\n"
                + "\t 2. Agregar producto\n"
                + "\t 3. Listar producto\n"
                + "\t 4. Buscar producto\n"
                + "\t 5. Eliminar  prodcucto\n"
                + "\t 6. Agregar producto por teclado\n"
                + "\t 0. Salir\n"
                + "Introduzca una opcion:\n"
                + ""
        );
        do {
            Scanner sn = new Scanner(System.in);
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    datosProductos.iniciarArchivo();
                    System.out.println("\n¿Que más quieres hacer?");
                    break;
                case 2:
                    datosProductos.agregar("triptico", TamanioPapel.A4, true, TipoPapel.MATE, 200, true, TipoPlastificado.NO, false, TipoEncuadernado.NO, true);
                    //datosProductos.agregar("productos.txt", 3, "carpeta", TamanioPapel.A3, false, TipoPapel.MATE, 300, true, TipoPlastificado.ANTIRAYAS, false, TipoEncuadernado.NO, true);
                    //datosProductos.agregarTeclado("productos.txt", p1);
                    //introducirProductoPorTeclado();
                    System.out.println("\n¿Que más quieres hacer?");
                    break;
                case 3:
                    datosProductos.listar();
                    System.out.println("\n¿Que más quieres hacer?");
                    break;
                case 4:
                    datosProductos.buscar("tarjetass");
                    System.out.println("\n¿Que más quieres hacer?");
                    break;
                case 5:
                    datosProductos.borrar("carpeta");
                    System.out.println("\n¿Que más quieres hacer?");
                    break;
                case 6:
                    introducirProductoPorTeclado();
                    System.out.println("\n¿Que más quieres hacer?");
                    break;
                case 0:
                    System.out.println("Gracias!");
                    break;
                default:
                    System.out.println("Valor erroneo");
            }
        } while (opcion != 0);
    }

    public static void introducirProductoPorTeclado() {
        ICatalogoProductos datosProductos1 = new CatalogoProductosImp();

        int id, gramaje, enumerado;
        String nombreProd;
        TamanioPapel tamanio;
        TipoPapel papel;
        TipoPlastificado plastificado;
        TipoEncuadernado encuadernado;
        boolean caras, color, puntasRed, plegado;

        // [EDU] Este tipo de clases (como el PrintWriter, Buffer, etc) habría que cerrarlas también 
        Scanner sn = new Scanner(System.in);

        System.out.println("Introduce los datos del producto :) ");
        /*System.out.println("ID:");
        id = sn.nextInt();//NO ME COGE ESTE CAMPO Y TODO EL RATO PONE 1, HE PROBADO USANDO EL CONSTRUCTOR SIN ID
*/
        System.out.println("Nombre producto:");
        nombreProd = sn.next();

        System.out.println("Escoja una opción de tamaño:");
        tamanio = SeleeccionarEnm.SeleccionarTamanioPapel();

        System.out.println("¿Es a dos caras? (true o false)");
        caras = sn.nextBoolean();

        // System.out.println("Papel:");
        papel = SeleeccionarEnm.SeleccionarTipoPapel();

        System.out.println("Gramaje:");
        gramaje = sn.nextInt();

        System.out.println("¿Es a color? (true o false)");
        color = sn.nextBoolean();

        //System.out.println("Plastificado:");
        plastificado = SeleeccionarEnm.SeleccionarPlastificado();

        System.out.println("¿Puntas redondeadas? (true o false)");
        puntasRed = sn.nextBoolean();

        //System.out.println("Encuadernado:");
        encuadernado = SeleeccionarEnm.SeleccionarEncuadernado();

        System.out.println("¿LLeva plegado? (true o false)");
        plegado = sn.nextBoolean();

        datosProductos1.agregar(nombreProd, tamanio, caras, papel, gramaje, color, plastificado, puntasRed, encuadernado, plegado);
        //Producto p1 = new Producto(nombreProd, tamanio, caras, papel, gramaje, color, plastificado, puntasRed, encuadernado, plegado);
    }
}
