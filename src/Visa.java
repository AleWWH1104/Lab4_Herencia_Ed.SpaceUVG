/**
 * Clase que representa una pasarela de pago Visa.
 */
public class Visa extends Transaction implements Pasarela_Pago {
    private double originalAmount;
    private double serviceFee;
    private double iva;
    private double totalAmount;

    /**
     * Constructor para crear una transacción Visa.
     *
     * @param user           Nombre de usuario.
     * @param id             Identificador de la transacción.
     * @param publicKey      Clave pública.
     * @param amount         Monto de la transacción.
     * @param cuotas         Número de cuotas (opcional).
     * @param cardNumber     Número de tarjeta de crédito.
     * @param expirationDate Fecha de vencimiento de la tarjeta.
     * @param cvv            Código de seguridad CVV.
     */
    public Visa(String user, long id, String publicKey, double amount, long cuotas, long cardNumber,
            long expirationDate,
            long cvv) {
        super(user, id, publicKey, amount, cuotas, cardNumber, expirationDate, cvv);
    }

    /**
     * Procesa el pago, calcula la comisión de servicio, el IVA y el monto total.
     */
    @Override
    public void procesar_pago() {
        originalAmount = this.getAmount();
        serviceFee = originalAmount * 0.05; // 5% de comisión de servicio
        iva = serviceFee * 0.12; // 12% de IVA de comisión
        totalAmount = originalAmount + serviceFee - iva;
        this.setAmount(totalAmount);
    }

    /**
     * Cambia la pasarela actual a otra pasarela Visa, copiando los atributos de la
     * nueva pasarela.
     *
     * @param nuevaPasarela Nueva pasarela Visa.
     */
    @Override
    public void cambiar_pasarela(Pasarela_Pago nuevaPasarela) {
        if (nuevaPasarela instanceof Visa) {
            Visa nuevaVisa = (Visa) nuevaPasarela;
            this.setUser(nuevaVisa.getUser());
            this.setId(nuevaVisa.getId());
            this.setPublicKey(nuevaVisa.getPublicKey());
            this.setAmount(nuevaVisa.getAmount());
            this.setCuotas(nuevaVisa.getCuotas());
            this.setCardNumber(nuevaVisa.getCardNumber());
            this.setExpirationDate(nuevaVisa.getExpirationDate());
            this.setCvv(nuevaVisa.getCvv());
        }
    }

    /**
     * Obtiene el monto original de la transacción.
     *
     * @return Monto original de la transacción.
     */
    public double getOriginalAmount() {
        return originalAmount;
    }

    /**
     * Obtiene la comisión de servicio calculada.
     *
     * @return Comisión de servicio.
     */
    public double getServiceFee() {
        return serviceFee;
    }

    /**
     * Obtiene el impuesto al valor agregado (IVA) calculado.
     *
     * @return IVA de comisión.
     */
    public double getIVA() {
        return iva;
    }

    /**
     * Obtiene el monto total de la transacción después de aplicar comisión y IVA.
     *
     * @return Monto total de la transacción.
     */
    public double getTotalAmount() {
        return totalAmount;
    }
}
