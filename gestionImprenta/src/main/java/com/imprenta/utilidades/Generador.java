package com.imprenta.utilidades;

import com.imprenta.datos.AccesoDatosImp;
import com.imprenta.datos.IAccesoDatos;

/**
 * Clase para generar distintos IDs
 */
public class Generador {

    private static int contador_producto = -1;

    /**
     * Genera un nuevo ID para {@link com.imprenta.dominio.Producto}
     * 
     * @return El nuevo ID
     */
    public static int generarIdProducto() {
        if (contador_producto == -1) {
            // Recupera el ultimo ID del fichero
            final IAccesoDatos datos = new AccesoDatosImp();
            final int ultimoID = datos.buscarUltimoID();

            // Si no hemos encontrado ningun ID, iniciamos a 1
            if (ultimoID == -1) {
                contador_producto = 1;
            } else {
                // Si hemos encontrado algun ID, usamos el siguiente
                contador_producto = ultimoID + 1;
            }
        }
        
        // Devolvemos el nuevo ID e incrementamos
        return contador_producto++;
    }
}