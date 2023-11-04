
/**
 * La interfaz CargarArchivosI define un contrato para cargar datos desde un archivo y devolver una lista de objetos de un tipo genérico.
 *
 * @param <T> El tipo de objetos que se cargarán desde el archivo.
 * @version 1.0
 * @since [Fecha de Creación]
 */
import java.util.List;

public interface CargarArchivosI<T> {
    /**
     * Carga datos desde un archivo ubicado en la ruta especificada y los devuelve
     * 
     * como una lista de objetos del tipo genérico T.
     *
     * @param filePath La ruta del archivo desde el cual cargar los datos.
     * 
     * @return Una lista de objetos del tipo genérico T que representan los datos
     *         cargados desde el archivo.
     */
    List<T> loadData(String filePath);

}