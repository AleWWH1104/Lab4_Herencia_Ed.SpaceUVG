import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AmericanExpress extends Transaction implements Pasarela_Pago {
    private StringBuilder hashMD5;

    public StringBuilder getHashMD5() {
        return hashMD5;
    }

    public AmericanExpress(String user, int id, String publicKey, double amount, int cuotas, long cardNumber,
            int expirationDate, int cvv) {
        super(user, id, publicKey, amount, cuotas, cardNumber, expirationDate, cvv);
        this.hashMD5 = generateHashMD5(user);
    }

    @Override
    public void procesar_pago() {
        double montoOriginal = this.getAmount();
        double servicio = 0.07 * montoOriginal;
        int cuotas = this.getCuotas();
        if (cuotas > 1) {
            servicio += 0.15 * montoOriginal;
            
        }
        double nuevoMonto = montoOriginal + servicio;
        this.setAmount(nuevoMonto);
    }

    private StringBuilder generateHashMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder hashString = new StringBuilder();
            for (byte b : hashBytes) {
                hashString.append(String.format("%02x", b));
            }

            return hashString;
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algoritmo MD5 no compatible.");
            return new StringBuilder();
        }
    }

    @Override
    public void cambiar_pasarela(Pasarela_Pago nuevaPasarela) {
    }

}
