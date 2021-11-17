package com.imprenta.negocio;

import com.imprenta.datos.*;
import com.imprenta.dominio.*;
import com.imprenta.excepciones.*;
import java.util.*;

public class CatalogoProductosImp implements ICatalogoProductos {

    private final IAccesoDatos datos;//Puente de comunicacion

    public CatalogoProductosImp() {
        this.datos = new AccesoDatosImp();
    }

    @Override
    public void agregar(String nombreArchivo,  String nombre_producto, TamanioPapel medida, boolean is_2_caras, TipoPapel papel, int gramaje, boolean is_Color, TipoPlastificado plastificado, boolean puntasRedondeaDas, TipoEncuadernado encuadernado, boolean is_plegado) {
        try {
            Producto productos = new Producto(  nombre_producto,  medida,  is_2_caras,  papel,  gramaje,  is_Color,   plastificado,  puntasRedondeaDas,  encuadernado,  is_plegado);
            if (datos.existe(nombreArchivo) == true) {
                datos.escribir(productos, nombreArchivo, true);
            } else {
                System.out.println("El archivo no existe");
            }
        } catch (EscrituraDatosEx ex) {
            ex.printStackTrace(System.out);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }
    
   /* @Override
    public void agregarTeclado(String nombreArchivo, Producto producto){
        try {
          if (datos.existe(nombreArchivo) == true) {
                datos.escribir(producto, nombreArchivo, true);
            } else {
                System.out.println("El archivo no existe");
            }
        } catch (EscrituraDatosEx ex) {
            ex.printStackTrace(System.out);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }*/
    
     @Override
    public void listar(String nombreArchivo) {
        List<Producto> lista = new ArrayList<>();
        try {
            lista = datos.listar(nombreArchivo);
            for (int i = 0; i < lista.size(); i++){
                System.out.println( "Prodcuto: " +
                        + lista.get(i).getId_trabajo()
                + " | " + lista.get(i).getNombre_trabajo()
                + " | " + lista.get(i).getMedida()
                + " | " + lista.get(i).isIs_2_caras()
                + " | " + lista.get(i).getPapel()
                + " | " + lista.get(i).getGramaje()
                + " | " + lista.get(i).isIs_Color()
                + " | " + lista.get(i).getPapel()
                + " | " + lista.get(i).isPuntasRedondeaDas()
                + " | " + lista.get(i).getEncuadernado()
                + " | " + lista.get(i).isIs_plegado());
            }
            /*
            lista.forEach(producto -> { 
                System.out.println( "Prodcuto: " +
                        + producto.getId_trabajo()
                + " | " + producto.getNombre_trabajo()
                + " | " + producto.getMedida()
                + " | " + producto.isIs_2_caras()
                + " | " + producto.getPapel()
                + " | " + producto.getGramaje()
                + " | " + producto.isIs_Color()
                + " | " + producto.getPapel()
                + " | " + producto.isPuntasRedondeaDas()
                + " | " + producto.getEncuadernado()
                + " | " + producto.isIs_plegado());
            });
            */

        } catch (LecturaDatosEx e) {
            System.out.println("Error leyendo el catalogo");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void buscar(String nombreArchivo, String buscar) {
        try {
            System.out.println(datos.buscar(nombreArchivo, buscar));
        } catch (LecturaDatosEx e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            if (datos.existe(nombreArchivo) == false) {
                datos.crear(nombreArchivo);
            } else {
                System.out.println("El archivo ya existe");
            }

        } catch (AccesoDatosEx e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void borrar(String nombreArchivo, String buscar) {
        datos.borrar(nombreArchivo, buscar);
        System.out.println("Catalogo eliminado con exito");
    }

}
