import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLGenerator implements GenerarArchivosI<Visa> {
    
    @Override
    public void generarArchivo(List<Visa> transacciones, String nombreArchivo) {
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
