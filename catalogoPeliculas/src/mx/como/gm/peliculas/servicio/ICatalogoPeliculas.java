
package mx.como.gm.peliculas.servicio;

/**
 *
 * @author JOSE
 */
public interface ICatalogoPeliculas {
    String nombre_recurso = "Pelicula.txt";
    void agregarPelicula(String nombrePelicula);
    void listarPeliculas();
    void buscarPelicula(String buscar);
    void iniciarCatalogoPeliculas();
    
    
    
    
}
