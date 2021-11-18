package com.imprenta.datos;

// [EDU] Te recomiendo evitar los import así, se pierde visibilidad de las dependencias que tiene la clase
import com.imprenta.excepciones.*;
import com.imprenta.dominio.*;
// [EDU] Sin embargo con esto sabes fácilmente que sólo dependes de List dentro de java.util
import java.util.List;

// [EDU] Si esta clase va a acabar siendo específica para Producto, vendría bien llamarla IAccesoDatosProducto, por ejemplo
// (Y lo mismo con la implementación, igual que con la de catalogo)
public interface IAccesoDatos {

    boolean existe() throws AccesoDatosEx;

    List<Producto> listar() throws LecturaDatosEx;

    void escribir(Producto producto, boolean anexar) throws EscrituraDatosEx;

    String buscar(String buscar) throws LecturaDatosEx;

    void crear() throws AccesoDatosEx;

    void borrar(String buscar);

}
