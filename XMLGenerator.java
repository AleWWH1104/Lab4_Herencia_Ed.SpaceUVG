import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLGenerator {
    public void generarXML(Visa visa, String nombreArchivo) {
        // Lógica para generar el archivo XML a partir de una sola transacción Visa
        String xmlData = "<Transaccion>\n" +
                         "  <User>" + visa.getUser() + "</User>\n" +
                         "  <Id>" + visa.getId() + "</Id>\n" +
                         "  <PublicKey>" + visa.getPublicKey() + "</PublicKey>\n" +
                         "  <Amount>" + visa.getAmount() + "</Amount>\n" +
                         "  <!-- Otros campos de la transacción -->\n" +
                         "</Transaccion>";

        guardarArchivoXML(xmlData, nombreArchivo);
    }

    public void generarXML(List<Visa> transacciones, String nombreArchivo) {
        // Lógica para generar un archivo XML a partir de una lista de transacciones Visa
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
