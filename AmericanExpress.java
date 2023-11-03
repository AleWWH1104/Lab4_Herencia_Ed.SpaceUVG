public class AmericanExpress extends Transaction implements Pasarela_Pago {

    private StringBuilder hashMD5;

    public void setHashMD5(StringBuilder hashMD5) {
        this.hashMD5 = hashMD5;
    }

    public StringBuilder getHashMD5() {
        return hashMD5;
    }

    public AmericanExpress(String user, int id, String publicKey, double amount, int cuotas, long cardNumber, int expirationDate,
            int cvv, StringBuilder hashMD5) {
        super(user, id, publicKey, amount,cuotas, cardNumber, expirationDate, cvv);
        this.hashMD5 = hashMD5;
    }
    @Override
    public void procesar_pago() {
        Double montoOriginal = this.getAmount();
        //7% de servicio
        Double servicio = 0.07 * montoOriginal;
        Integer cuotas = this.getCuotas();
        if (cuotas != null && cuotas > 1){
            // Si hay cuotas, incrementa el monto en un 15%
            servicio = servicio + (0.15 * montoOriginal);
        }
        double nuevoMonto = montoOriginal + servicio;
        this.setAmount(nuevoMonto); 
    }

    @Override
    public void cambiar_pasarela(Pasarela_Pago nuevaPasarela) {
      }
    
}
