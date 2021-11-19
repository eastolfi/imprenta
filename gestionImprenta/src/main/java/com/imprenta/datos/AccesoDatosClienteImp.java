package com.imprenta.datos;

import com.imprenta.dominio.Producto;
import com.imprenta.dominio.*;
import com.imprenta.excepciones.*;
import java.io.*;
import java.util.*;

public class AccesoDatosClienteImp extends AccesoDatosAbstract<Cliente> {

    @Override
    protected Cliente convertirLinea(String[] linea) {
        var cliente = new Cliente();

        cliente.setNombre_completo(linea[0]);

        return cliente;
    }
    
    @Override
    protected String construirLinea(Cliente elemento) {
        return elemento.getNombre_completo() + ";" + elemento.getCif();
    }
}
