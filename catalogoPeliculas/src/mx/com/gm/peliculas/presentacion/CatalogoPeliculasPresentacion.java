package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;
import mx.como.gm.peliculas.servicio.*;

/**
 *
 * @author JOSE
 */
public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("Elije una opcion \n"
                    + "1. Iniciar Catalogo de Peliculas \n"
                    + "2. Agregar Pelicula \n"
                    + "3. Listar Pelicula \n"
                    + "4. Buscar Pelicula \n"
                    + "0. Salir \n");
            opcion = Integer.parseInt(sc.nextLine()); // Hacemos una converson se recomiendo el metodo nextLine ya que consume toda la linea inclusive el saldo de linea
            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introdcuce el nombre de la pelicula ");
                    String nombrePelicula = sc.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce una pelicula a buscar: ");
                    String buscar = sc.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("***HASTA PRONTO**");
                    break;
                default:
                    System.out.println("Opcion no reconocida ");
                    break;

            }

        }
    }

}
