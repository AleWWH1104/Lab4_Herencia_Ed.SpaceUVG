import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ruta del archivo JSON a cargar
        String filePath = "data";

        JSONManager jsonManager = new JSONManager();

        // Cargar los datos desde el archivo JSON
        List<HashMap<String, Object>> jsonData = jsonManager.loadData(filePath);
        TransactionManager.cargas(jsonData);

    }
}
