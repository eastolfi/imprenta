package com.imprenta.datos;

import com.imprenta.dominio.*;
import com.imprenta.excepciones.*;
import java.io.*;
import java.util.*;

// Esta es una clase abstracta. En ella podemos definir la implementación de algunos métodos
// o simpliemente dejar la estructura como en una interfaz
// Aquí además, mantenemos el tipo génerico
public abstract class AccesoDatosAbstract<T> implements IAccesoDatos<T> {
    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    /**
     * TRADUCE DE TEXTO A OBJ
     * 
     * @return Lista de Elementos
     */
    @Override
    public List<T> listar(String nombreArchivo) throws LecturaDatosEx {
        List<T> listaProd = new ArrayList<T>();

        try {
            BufferedReader entrada = obtenerEntrada(nombreArchivo);
            var lectura = entrada.readLine();

            while (lectura != null) {
                // En vez de hacer aqui la conversion, llamamos a un metodo separado
                listaProd.add(convertirLinea(lectura.split(";")));
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
    public void escribir(T elemento, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        try {
            PrintWriter salida = obtenerSalida(nombreArchivo);
            // En vez de hacer aqui la conversion, llamamos a un metodo separado
            salida.println(construirLinea(elemento));
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
        String mensaje = "";
        int linea = 0;

        try {
            BufferedReader entrada = obtenerEntrada(nombreArchivo);
            var lectura = entrada.readLine();

            while (lectura != null) {
                String[] cadenaElemento = lectura.split(";");
                linea = linea + 1;
                if (cadenaElemento[1].equalsIgnoreCase(buscar)) {
                    mensaje = "Nombre del archivo : " + nombreArchivo + "\n" + "Elemento : " + lectura + "\n" + "Linea : " + linea;
                    break;
                }
                lectura = entrada.readLine();
            }

            if (lectura == null) {
                System.out.println("El elemento no esta en el catálogo");
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
        try {
            PrintWriter salida = obtenerSalida(nombreArchivo);
            salida.close();
            System.out.println("Se ha creado con exito el archivo");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            //throw new ExcepcionEscrituraDatosEx("No se ha podido crear el archivo");
        }
    }

    @Override
    public void borrar(String nombreArchivo, String buscar) {
        try {
            BufferedReader entrada = obtenerEntrada(nombreArchivo);
            var lectura = entrada.readLine();

            //Creamos el archivo
            PrintWriter salida = obtenerSalida(nombreArchivo);
            System.out.println("Se ha creado con exito el archivo");

            while (lectura != null) {
                String[] cadenaElemento = lectura.split(";");

                if (cadenaElemento[1].equalsIgnoreCase(buscar)) {
                    lectura = entrada.readLine();
                    continue;
                }

                //Escribimos las lineas que no queremos eliminar
                salida = obtenerSalida(nombreArchivo);
                salida.println(lectura);
                salida.close();

                //Pasamos a la siguiente linea
                lectura = entrada.readLine();
            }

            if (lectura == null) {
                if (this.borrarFicheroSiExiste(nombreArchivo)) {
                    System.out.println("El archivo ha sido eliminado");
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

    // Esto es un metodo abstracto. Eso quiere decir, que su implementacion dependera de las
    // clases que heredan esta clase (abstracta)
    protected abstract T convertirLinea(String[] linea);
    
    protected abstract String construirLinea(T elemento);

    private PrintWriter obtenerSalida(String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);

        return new PrintWriter(new FileWriter(archivo, true));
    }

    private BufferedReader obtenerEntrada(String nombreArchivo) throws FileNotFoundException {
        File archivo = new File(nombreArchivo);

        return new BufferedReader(new FileReader(archivo));
    }

    private boolean borrarFicheroSiExiste(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        if (archivo.exists()) {
            archivo.delete();
            
            return true;
        }

        return false;
    }

}
