import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVGenerator {
    public void escribirCSV(List<AmericanExpress> transacciones, String rutaArchivoCSV) {
        try (FileWriter writer = new FileWriter(rutaArchivoCSV, true)) { // El true indica que se añadirán datos al
                                                                         // archivo existente
            for (AmericanExpress transaccion : transacciones) {
                // Obtener los datos de la transacción
                String usuario = transaccion.getUser();
                int id = transaccion.getId();
                String public_key = transaccion.getPublicKey();
                double monto = transaccion.getAmount();
                int cuotas = transaccion.getCuotas();
                long numero_de_tarjeta = transaccion.getCardNumber();
                int fecha_de_vencimiento = transaccion.getExpirationDate();
                int codigo_CVV = transaccion.getCvv();
                StringBuilder hashMD5 = transaccion.getHashMD5();

                // Escribir los datos al archivo CSV
                writer.append(usuario + "," + id + "," + public_key + "," + monto + "," + cuotas + "," +
                        numero_de_tarjeta + "," + fecha_de_vencimiento + "," + codigo_CVV + "," + hashMD5);
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}