package com.imprenta.datos;

import com.imprenta.excepciones.*;
import com.imprenta.dominio.*;
import java.util.List;

// La parte de "<T>" hace que esta interfaz esté tipada
// Cuando la usemos, será IAccesoDatos<Producto> datos = new ....
// Así aquí, cada vez que queramos hacer referencia al tipo, usamos T, y en ese ejemplo, usará Producto
public interface IAccesoDatos<T> {

    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    List<T> listar(String nombreArchivo) throws LecturaDatosEx;

    void escribir(T elemento, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear(String nombreArchivo) throws AccesoDatosEx;

    void borrar(String nombreArchivo, String buscar);
}
