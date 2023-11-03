import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Visa implements Pasarela_Pago {
    private Pasarela_Pago pasarelaSustituta; // Variable para la nueva pasarela de pago

    @Override
    public void procesar_pago(List<Map<String, Object>> transactions) {
        for (Map<String, Object> transactionData : transactions) {
            double originalAmount = (double) transactionData.get("Amount");
            double serviceFee = originalAmount * 0.05; // 5% de comisión de servicio
            double iva = serviceFee * 0.12; // 12% de IVA de comisión
            double totalAmount = originalAmount + serviceFee - iva;

            // Formatear el archivo a formato XML
            String xmlData = formatToXML(transactionData, totalAmount);

            // Guardar o imprimir el archivo XML, según tus necesidades
            saveToFile(xmlData, "visa_payment_" + transactionData.get("Id") + ".xml");
        }
    }

    @Override
    public void cambiar_pasarela(Pasarela_Pago nuevaPasarela) {

        pasarelaSustituta = nuevaPasarela;
    }

    // Método para formatear el archivo a XML
    private String formatToXML(Map<String, Object> transactionData, double totalAmount) {

        String xmlData = "<Payment>";
        xmlData += "<User>" + transactionData.get("User") + "</User>";
        xmlData += "<Id>" + transactionData.get("Id") + "</Id>";
        xmlData += "<Public Key>" + transactionData.get("Public Key") + "</Public Key>";
        xmlData += "<Amount>" + totalAmount + "</Amount>";
        xmlData += "<Card Number>" + maskCardNumber((long) transactionData.get("Card Number")) + "</Card Number>";
        xmlData += "<Expiration Date>" + transactionData.get("Expiration Date") + "</Expiration Date>";
        xmlData += "<CVV>" + transactionData.get("CVV") + "</CVV>";
        xmlData += "</Payment>";
        return xmlData;
    }

    // Método para enmascarar el número de tarjeta
    private String maskCardNumber(long cardNumber) {
        // Implementa la lógica para enmascarar el número de tarjeta
        String cardNumberStr = Long.toString(cardNumber);
        int length = cardNumberStr.length();
        StringBuilder maskedCardNumber = new StringBuilder();
        for (int i = 0; i < length - 4; i++) {
            maskedCardNumber.append("*");
        }
        maskedCardNumber.append(cardNumberStr.substring(length - 4));
        return maskedCardNumber.toString();
    }

    // Método para guardar o imprimir el archivo
    private void saveToFile(String data, String filename) {
        // Implementa la lógica para guardar o imprimir el archivo aquí
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(data);
            System.out.println("Archivo guardado: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al guardar el archivo: " + filename);
        }
    }
}
