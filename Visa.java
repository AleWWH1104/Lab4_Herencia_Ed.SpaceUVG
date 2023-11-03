public class Visa extends Transaction implements Pasarela_Pago {
    private double originalAmount;
    private double serviceFee;
    private double iva;
    private double totalAmount;

    public Visa(String user, int id, String publicKey, double amount, int cuotas, long cardNumber, int expirationDate, int cvv) {
        super(user, id, publicKey, amount,cuotas, cardNumber, expirationDate, cvv);
    }

    @Override
    public void procesar_pago() { 
        originalAmount = this.getAmount();
        serviceFee = originalAmount * 0.05; // 5% de comisión de servicio
        iva = serviceFee * 0.12; // 12% de IVA de comisión
        totalAmount = originalAmount + serviceFee - iva;
        this.setAmount(totalAmount);
    }

    @Override
    public void cambiar_pasarela(Pasarela_Pago nuevaPasarela) {
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public double getIVA() {
        return iva;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
