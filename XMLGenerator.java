import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLGenerator {
    public void generarXML(Transaction transaccion, String nombreArchivo) {
        // Lógica para generar el archivo XML a partir de una sola transacción
        String xmlData = "<Transaccion>\n" +
                         "  <User>" + transaccion.getUser() + "</User>\n" +
                         "  <Id>" + transaccion.getId() + "</Id>\n" +
                         "  <PublicKey>" + transaccion.getPublicKey() + "</PublicKey>\n" +
                         "  <Amount>" + transaccion.getAmount() + "</Amount>\n" +
                         "  <!-- Otros campos de la transacción -->\n" +
                         "</Transaccion>";

        guardarArchivoXML(xmlData, nombreArchivo);
    }

    public void generarXML(List<Transaction> transacciones, String nombreArchivo) {
        // Lógica para generar un archivo XML a partir de una lista de transacciones
        StringBuilder xmlData = new StringBuilder();
        xmlData.append("<Transacciones>\n");
        for (Transaction transaccion : transacciones) {
            xmlData.append("  <Transaccion>\n");
            xmlData.append("    <User>" + transaccion.getUser() + "</User>\n");
            xmlData.append("    <Id>" + transaccion.getId() + "</Id>\n");
            xmlData.append("    <PublicKey>" + transaccion.getPublicKey() + "</PublicKey>\n");
            xmlData.append("    <Amount>" + transaccion.getAmount() + "</Amount>\n");
            xmlData.append("    <!-- Otros campos de la transacción -->\n");
            xmlData.append("  </Transaccion>\n");
        }
        xmlData.append("</Transacciones>");

        guardarArchivoXML(xmlData.toString(), nombreArchivo);
    }

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
