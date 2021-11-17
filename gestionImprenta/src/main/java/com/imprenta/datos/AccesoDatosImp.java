package com.imprenta.datos;

import com.imprenta.dominio.Producto;
import com.imprenta.dominio.*;
import com.imprenta.excepciones.*;
import java.io.*;
import java.util.*;

public class AccesoDatosImp implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    //TRADUCE DE TEXTO A OBJ
    public List<Producto> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        List<Producto> listaProd = new ArrayList<Producto>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();

            while (lectura != null) {
                String[] arrProducto = lectura.split(";");
                Producto producto = new Producto(
                        Integer.parseInt(arrProducto[0]),
                        arrProducto[1],
                        TamanioPapel.valueOf(arrProducto[2]),
                        Boolean.parseBoolean(arrProducto[3]),
                        TipoPapel.valueOf(arrProducto[4]),
                        Integer.parseInt(arrProducto[5]),
                        Boolean.parseBoolean(arrProducto[6]),
                        TipoPlastificado.valueOf(arrProducto[7]),
                        Boolean.parseBoolean(arrProducto[8]),
                        TipoEncuadernado.valueOf(arrProducto[9]),
                        Boolean.parseBoolean(arrProducto[10]));
                listaProd.add(producto);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listaProdndo las peliculas");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return listaProd;
    }

    @Override
    public void escribir(Producto producto, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        String escribir = producto.getId_trabajo()
                + ";" + producto.getNombre_trabajo()
                + ";" + producto.getMedida()
                + ";" + producto.isIs_2_caras()
                + ";" + producto.getPapel()
                + ";" + producto.getGramaje()
                + ";" + producto.isIs_Color()
                + ";" + producto.getPapel()
                + ";" + producto.isPuntasRedondeaDas()
                + ";" + producto.getEncuadernado()
                + ";" + producto.isIs_plegado();
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(escribir);
            salida.close();
            System.out.println("Escrito el contenido con exito\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            System.out.println("El archivo no existe");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        File archivo = new File(nombreArchivo);
        String mensaje = "";
        int linea = 0;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();

            while (lectura != null) {
                String[] cadenaProducto = lectura.split(";");
                linea = linea + 1;
                if (cadenaProducto[1].equalsIgnoreCase(buscar)) {
                    mensaje = "Nombre del archivo : " + nombreArchivo + "\n" + "Producto : " + lectura + "\n" + "Linea : " + linea;
                    break;
                }
                lectura = entrada.readLine();
            }

            if (lectura == null) {
                System.out.println("El producto no esta en el catálogo");
            }
            entrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            System.out.println("Error al leerlo");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("No se ha encontrado el archivo");
        }

        return mensaje;
    }

    @Override
    public void crear(String nombreArchivo) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado con exito el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            //throw new ExcepcionEscrituraDatosEx("No se ha podido crear el archivo");
        }
    }

    @Override
    public void borrar(String nombreArchivo, String buscar) {
        File archivo = new File(nombreArchivo);

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();

            //Creamos el archivo
            PrintWriter salida = new PrintWriter(archivo);
            System.out.println("Se ha creado con exito el archivo");

            while (lectura != null) {
                String[] cadenaProducto = lectura.split(";");

                if (cadenaProducto[1].equalsIgnoreCase(buscar)) {
                    lectura = entrada.readLine();
                    continue;
                }

                //Escribimos las lineas que no queremos eliminar
                salida = new PrintWriter(new FileWriter(archivo, true));
                salida.println(lectura);
                salida.close();

                //Pasamos a la siguiente linea
                lectura = entrada.readLine();
            }

            if (lectura == null) {
                if (archivo.exists() == true) {
                    archivo.delete();
                    System.out.println("El archivo a sido eliminado");
                } else {
                    System.out.println("El archivo que quieres eliminar no existe");
                }
                System.out.println("Se han eliminado las lineas");
            }
            entrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            System.out.println("Error al leerlo");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("No se ha encontrado el archivo");
        }
    }

}
