import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * La clase TransactionManager se encarga de procesar los datos cargados desde
 * un archivo JSON y crear instancias de transacciones Visa, MasterCard y
 * American Express según el tipo de tarjeta. Luego, genera archivos XML, JSON y
 * CSV con la información de las transacciones.
 *
 * @version 1.0
 * @author Jonathan y David
 * @since 3 11 23
 */
public class TransactionManager {

    /**
     * Procesa los datos cargados desde un archivo JSON y crea instancias de
     * transacciones Visa, MasterCard y American Express según el tipo de tarjeta.
     * Luego, genera archivos XML, JSON y CSV con la información de las
     * transacciones.
     *
     * @param jsonData Los datos cargados desde el archivo JSON en forma de una
     *                 lista de mapas.
     */
    public static void cargas(List<HashMap<String, Object>> jsonData) {
        List<Visa> transaccionesVisa = new ArrayList<>();
        List<AmericanExpress> transaccionesAEX = new ArrayList<>();
        List<MasterCard> transaccionesMasterCard = new ArrayList<>();

        for (HashMap<String, Object> item : jsonData) {
            Object numeroDeTarjetaObj = item.get("numero_de_tarjeta");

            if (numeroDeTarjetaObj != null) {
                if (numeroDeTarjetaObj instanceof Long) {
                    Long numeroDeTarjeta = (Long) numeroDeTarjetaObj;
                    String usuario = (String) item.get("usuario");
                    Long id = (Long) item.get("id");
                    String public_key = (String) item.get("public_key");
                    double monto = (double) item.get("monto");
                    Long cuotas = (Long) item.get("cuotas");
                    Long fecha_de_vencimiento = (Long) item.get("fecha_de_vencimiento");
                    Long cvv = (Long) item.get("codigo_CVV");

                    String numeroDeTarjetaS = numeroDeTarjeta.toString();

                    char primerDigito = numeroDeTarjetaS.charAt(0);
                    if (primerDigito == '4') {
                        System.out.println("Visa");
                        Visa transaccionVisa = new Visa(usuario, id, public_key, monto, cuotas, numeroDeTarjeta,
                                fecha_de_vencimiento, cvv);
                        transaccionesVisa.add(transaccionVisa);
                    } else if (primerDigito == '5') {
                        System.out.println("MasterCard");
                        MasterCard transaccionMC = new MasterCard(usuario, id, public_key, monto, cuotas,
                                numeroDeTarjeta,
                                fecha_de_vencimiento, cvv);
                        transaccionesMasterCard.add(transaccionMC);
                    } else if (primerDigito == '3') {
                        System.out.println("American Express");
                        AmericanExpress trannAEX = new AmericanExpress(numeroDeTarjetaS, id, public_key, monto, cuotas,
                                fecha_de_vencimiento, primerDigito, cvv);
                        transaccionesAEX.add(trannAEX);
                    } else {
                        System.out.println("No inicia con ninguno");
                    }
                } else if (numeroDeTarjetaObj instanceof String) {
                    String numeroDeTarjetaS = (String) numeroDeTarjetaObj;
                    // Aquí puedes manejar los casos en los que el número de tarjeta es una cadena.
                    // Por ejemplo, puedes verificar el primer dígito y realizar las acciones
                    // necesarias.
                }
            }
        }
        // Generar el archivo XML con la información de las transacciones Visa
        XMLGenerator xmlGenerator = new XMLGenerator();
        generarArchivo(xmlGenerator, transaccionesVisa, "transacciones_visa");
        JSONManager jsonManager = new JSONManager();
        generarArchivo(jsonManager, transaccionesMasterCard, "temp_JSON");
        CSVGenerator AEXGenerator = new CSVGenerator();
        generarArchivo(AEXGenerator, transaccionesAEX, "transacciones_AmEx");
    }

    private static <T> void generarArchivo(GenerarArchivosI<T> tipo, List<T> transacciones, String path) {
        tipo.generarArchivo(transacciones, path);
    }
}
