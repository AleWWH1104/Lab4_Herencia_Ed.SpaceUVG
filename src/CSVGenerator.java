import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * La clase CSVGenerator implementa la interfaz GenerarArchivosI y se encarga de
 * generar archivos CSV a partir de una lista de transacciones de
 * AmericanExpress.
 * 
 * @author Iris
 * @version 1.0
 * @since 3 11 23
 */
public class CSVGenerator implements GenerarArchivosI<AmericanExpress> {

    /**
     * Genera un archivo CSV a partir de una lista de transacciones de American
     * Express y lo guarda en la ruta especificada.
     *
     * @param transacciones  Lista de transacciones de American Express a ser
     *                       convertidas en un archivo CSV.
     * @param rutaArchivoCSV Ruta del archivo CSV de salida.
     */
    @Override
    public void generarArchivo(List<AmericanExpress> transacciones, String rutaArchivoCSV) {
        rutaArchivoCSV = rutaArchivoCSV + ".csv";
        try (FileWriter writer = new FileWriter(rutaArchivoCSV, true)) { // El true indica que se añadirán datos al
                                                                         // archivo existente
            for (AmericanExpress transaccion : transacciones) {
                // Obtener los datos de la transacción
                String usuario = transaccion.getUser();
                long id = transaccion.getId();
                String public_key = transaccion.getPublicKey();
                double monto = transaccion.getAmount();
                long cuotas = transaccion.getCuotas();
                long numero_de_tarjeta = transaccion.getCardNumber();
                long fecha_de_vencimiento = transaccion.getExpirationDate();
                long codigo_CVV = transaccion.getCvv();
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