import java.util.HashMap;
import java.util.List;

class Main {
    public static void main(String[] args) {
        // Ruta del archivo JSON a cargar
        String filePath = "data.json";

        JSONManager jsonManager = new JSONManager();

        // Cargar los datos desde el archivo JSON
        List<HashMap<String, Object>> jsonData = jsonManager.loadData(filePath);

        // Mostrar o procesar los datos cargados
        for (HashMap<String, Object> item : jsonData) {
            System.out.println("Usuario: " + item.get("usuario"));
            System.out.println("ID: " + item.get("id"));
            System.out.println("Public Key: " + item.get("public_key"));
            System.out.println("Monto: " + item.get("monto"));
            System.out.println("Cuotas: " + item.get("cuotas"));
            System.out.println("Número de Tarjeta: " + item.get("numero_de_tarjeta"));
            System.out.println("Fecha de Vencimiento: " + item.get("fecha_de_vencimiento"));
            System.out.println("Código CVV: " + item.get("codigo_CVV"));
            System.out.println();
        }
    }
}
