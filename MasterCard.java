import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Si el primer dígito de la tarjeta es un 5 entonces es una tarjeta Mastercard

public class MasterCard extends Transaction {

    private String codeHashMD5;
    private long cifEmperador;

    public MasterCard(String user, int id, String publicKey, double amount, long cardNumber, int expirationDate, int cvv, int cuotas) {
        super(user, id, publicKey, amount, cuotas, cardNumber, expirationDate, cvv);
    }

    public long getCifEmperador() {
        return cifradoEmperador.cifrar(this.getCardNumber(), 3);
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

}
