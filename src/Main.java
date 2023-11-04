import java.util.HashMap;
import java.util.List;

/**
 * La clase Main es la clase principal del programa que se encarga de cargar
 * datos desde un archivo JSON y procesarlos utilizando la clase JSONManager y
 * TransactionManager.
 *
 * @version 1.0
 * @author Jonathan & david
 * @since 3 11 23
 */
public class Main {
    public static void main(String[] args) {
        // Ruta del archivo JSON a cargar
        String filePath = "data";

        JSONManager jsonManager = new JSONManager();

        // Cargar los datos desde el archivo JSON
        List<HashMap<String, Object>> jsonData = jsonManager.loadData(filePath);

        // Procesar los datos cargados utilizando TransactionManager
        TransactionManager.cargas(jsonData);
    }
}
