import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Clase que se encarga de generar archivos XML a partir de una lista de
 * transacciones Visa.
 */
public class XMLGenerator implements GenerarArchivosI<Visa> {
    /**
     * Genera un archivo XML con la información de las transacciones Visa.
     *
     * @param transacciones Lista de transacciones Visa a incluir en el archivo XML.
     * @param nombreArchivo Nombre del archivo XML a generar.
     */
    @Override
    public void generarArchivo(List<Visa> transacciones, String nombreArchivo) {
        nombreArchivo = nombreArchivo + ".xml";
        StringBuilder xmlData = new StringBuilder();
        xmlData.append("<Transacciones>\n");
        for (Visa visa : transacciones) {
            xmlData.append("  <Transaccion>\n");
            xmlData.append("    <User>" + visa.getUser() + "</User>\n");
            xmlData.append("    <Id>" + visa.getId() + "</Id>\n");
            xmlData.append("    <PublicKey>" + visa.getPublicKey() + "</PublicKey>\n");
            xmlData.append("    <Amount>" + visa.getAmount() + "</Amount>\n");
            xmlData.append("    <!-- Otros campos de la transacción -->\n");
            xmlData.append("  </Transaccion>\n");
        }
        xmlData.append("</Transacciones>");

        guardarArchivoXML(xmlData.toString(), nombreArchivo);
    }

    /**
     * Guarda un archivo XML con los datos proporcionados en la cadena xmlData.
     *
     * @param xmlData       Cadena de datos XML a escribir en el archivo.
     * @param nombreArchivo Nombre del archivo XML a generar.
     */
    private void guardarArchivoXML(String xmlData, String nombreArchivo) {
        try (FileWriter fileWriter = new FileWriter(nombreArchivo)) {
            fileWriter.write(xmlData);
            System.out.println("Archivo XML generado: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al generar el archivo XML: " + e.getMessage());
        }
    }
}
