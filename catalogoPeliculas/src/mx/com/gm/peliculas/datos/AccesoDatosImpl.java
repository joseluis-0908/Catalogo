package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

/**
 *
 * @author JOSE
 */
public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        //UTILIZAMOS LO APRENDIDO EN MANEJO DE ARCHIVOS
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        //UTILIZAMOS LO APRENDIDO EN MANEJO DE ARCHIVOS
        File archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();// Añado como me dice el IDE un catch
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {//se utilizan las excepcioens del api de java
            ex.printStackTrace();
            throw new LecturaDatosEx("Exccepcion al listar Peliculas " + ex.getMessage());// con ello utilizo mis propias excepcioen y ver si hay algun error  
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Exccepcion al listar Peliculas " + ex.getMessage());// con ello utilizo mis propias excepcioen y ver si hay algun error  
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        //UTILIZAMOS LO APRENDIDO EN MANEJO DE ARCHIVOS
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));// abrmos un flujo para crear este archivo
            //para anexar la información utilizamos la variable de salida de esta forma:
            // con println nos imprime una nueva linea junto con el metodo toString para que se imprima este nuevo objeto de tipo pelicula
            salida.println(pelicula.toString());
            // Ya cuando se manda la informacion al archivo necesitamos cerrar el flujo de la siguente manera:
            salida.close();
            // mando un mensaje despues de cerrado el flujo como:
            System.out.println(" Se ha escrito el archivo " + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            // Analizo que clase estoy reportando en el metodo o que estoy lanzando como excepccion
            throw new EscrituraDatosEx("Exccepcion al escribir Peliculas " + ex.getMessage());// con ello utilizo mis propias excepcioen y ver si hay algun error  
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        //UTILIZAMOS LO APRENDIDO EN MANEJO DE ARCHIVOS
        File archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula" + linea + "encontrada en el inice: " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();// carramos el flujo de entrada del ciclo while
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Exccepcion al buscar la Peliculas " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Exccepcion al buscar la Peliculas " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public String crear(String nombreRecurso) throws AccesoDatosEx {
        //UTILIZAMOS LO APRENDIDO EN MANEJO DE ARCHIVOS
        String i = null;
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            throw new AccesoDatosEx("Excepcion al crear archivo:" + ex.getMessage());

        }
        return i;

    }

    @Override
    public String borrar(String nombreRecurso) throws AccesoDatosEx {
        //UTILIZAMOS LO APRENDIDO EN MANEJO DE ARCHIVOS
        
        File archivo = new File(nombreRecurso);
        if (archivo.exists()) 
            archivo.delete();
        System.out.println("Se ha borrado el archivo");
        return nombreRecurso;

    }

}
