
/**
 * La interfaz GenerarArchivosI define un contrato para generar archivos a partir de una lista de objetos de un tipo genérico T.
 *
 * @param <T> El tipo de objetos que se utilizarán para generar el archivo.
 * @author Jonathan
 * @version 1.0
 * @since 3 11 23
 */

import java.util.List;

public interface GenerarArchivosI<T> {

    /**
     * Genera un archivo a partir de una lista de objetos de tipo T y lo guarda en
     * la ruta especificada.
     *
     * @param transacciones Lista de objetos de tipo T a ser convertidos en un
     *                      archivo.
     * @param path          Ruta del archivo de salida.
     */
    void generarArchivo(List<T> transacciones, String path);
}
