package com.imprenta.negocio;

import com.imprenta.dominio.*;


public interface ICatalogoProductos {

    void agregar(String nombreArchivo,  String nombre_producto, TamanioPapel medida, boolean is_2_caras, TipoPapel papel, int gramaje, boolean is_Color, TipoPlastificado plastificado, boolean puntasRedondeaDas, TipoEncuadernado encuadernado, boolean is_plegado);

    //void agregarTeclado(String nombreArchivo, Producto producto);

    void listar(String nombreArchivo);

    void buscar(String nombreArchivo, String buscar);

    void iniciarArchivo(String nombreArchivo);

    void borrar(String nombreArchivo, String buscar);
}
