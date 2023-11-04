import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;

/**
 * La clase JSONManager se encarga de cargar datos desde un archivo JSON y
 * generar archivos JSON a partir de transacciones MasterCard.
 * Implementa las interfaces GenerarArchivosI y CargarArchivosI.
 *
 * @author Jonathan Diaz & David Dominguez
 * @version 1.0
 * @since 2023-11-3
 */
public class JSONManager implements GenerarArchivosI<MasterCard>, CargarArchivosI<HashMap<String, Object>> {

    /**
     * Carga datos desde un archivo JSON y los devuelve como una lista de mapas.
     *
     * @param filePath Ruta del archivo JSON desde el cual cargar los datos.
     * @return Una lista de mapas que representan los datos cargados desde el
     *         archivo JSON.
     */
    @Override
    public List<HashMap<String, Object>> loadData(String filePath) {
        filePath = filePath + ".json";
        JSONParser parser = new JSONParser();
        List<HashMap<String, Object>> data = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {
            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            for (Object o : jsonArray) {
                if (o instanceof JSONObject) {
                    JSONObject jsonObject = (JSONObject) o;
                    HashMap<String, Object> item = new HashMap<>(jsonObject);
                    data.add(item);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * Genera un archivo JSON a partir de una lista de transacciones MasterCard.
     *
     * @param transacciones   Lista de transacciones de MasterCard a ser convertidas
     *                        en JSON.
     * @param rutaArchivoJSON Ruta del archivo JSON de salida.
     */
    @Override
    public void generarArchivo(List<MasterCard> transacciones, String rutaArchivoJSON) {
        try {
            // Crear una lista para almacenar las transacciones en formato JSON
            List<Map<String, Object>> jsonTransacciones = new ArrayList<>();

            for (MasterCard transaccion : transacciones) {
                // Crear un mapa para almacenar los datos de la transacción en formato JSON
                Map<String, Object> jsonTransaccion = new HashMap<>();
                jsonTransaccion.put("user", transaccion.getUser());
                jsonTransaccion.put("id", transaccion.getId());
                jsonTransaccion.put("publicKey", transaccion.getPublicKey());
                jsonTransaccion.put("amount", transaccion.getAmount());

                long cardNumber = transaccion.getCifEmperador();

                jsonTransaccion.put("cardNumber", cardNumber);

                // Agregar la transacción a la lista de transacciones en formato JSON
                jsonTransacciones.add(jsonTransaccion);
            }

            // Convertir la lista de transacciones a una cadena JSON
            String jsonContent = new Gson().toJson(jsonTransacciones);

            // Calcular el hash MD5 del contenido del archivo
            StringBuilder hashMD5 = generateHashMD5(jsonContent);

            // Crear el nombre del archivo con el hash MD5
            String nombreArchivo = "archivo_" + hashMD5.toString() + ".json";

            // Crear un archivo JSON con el contenido y el nombre generado
            try (FileWriter fileWriter = new FileWriter(nombreArchivo)) {
                fileWriter.write(jsonContent);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Genera un hash MD5 a partir de una cadena de entrada.
     *
     * @param input La cadena de entrada para la cual se calculará el hash MD5.
     * @return Un StringBuilder que contiene el hash MD5 en formato hexadecimal.
     */
    private StringBuilder generateHashMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder hashString = new StringBuilder();
            for (byte b : hashBytes) {
                hashString.append(String.format("%02x", b));
            }

            return hashString;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new StringBuilder();
        }
    }
}
