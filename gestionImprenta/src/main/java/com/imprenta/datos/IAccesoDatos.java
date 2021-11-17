package com.imprenta.datos;

import com.imprenta.excepciones.*;
import com.imprenta.dominio.*;
import java.util.List;

public interface IAccesoDatos {

    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    List<Producto> listar(String nombreArchivo) throws LecturaDatosEx;

    void escribir(Producto producto, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear(String nombreArchivo) throws AccesoDatosEx;

    void borrar(String nombreArchivo, String buscar);
}
