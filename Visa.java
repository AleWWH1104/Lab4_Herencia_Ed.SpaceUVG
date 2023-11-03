public class Visa extends Transaction {
    public Visa(String user, int id, String publicKey, double amount, long cardNumber, int expirationDate, int cvv) {
        super(user, id, publicKey, amount, cardNumber, expirationDate, cvv);
    }

    public void procesarTransaccion() {
        // Lógica de procesamiento específica para Visa, como cálculo de tarifas, etc.
        double originalAmount = this.getAmount();
        double serviceFee = originalAmount * 0.05; // 5% de comisión de servicio
        double iva = serviceFee * 0.12; // 12% de IVA de comisión
        double totalAmount = originalAmount + serviceFee - iva;
        this.setAmount(totalAmount);

        // Generar archivo XML utilizando la clase XMLGenerator
        XMLGenerator xmlGenerator = new XMLGenerator();
        xmlGenerator.generarXML(this, "transacciones_visa.xml");
    }
}
