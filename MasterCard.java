import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

// Si el primer dígito de la tarjeta es un 5 entonces es una tarjeta Mastercard

public class MasterCard extends Transaction implements Pasarela_Pago{

    private StringBuilder hashMD5;
    public StringBuilder getHashMD5() {
        return hashMD5;
    }

    public MasterCard(String user, int id, String publicKey, double amount, long cardNumber, int expirationDate, int cvv, int cuotas) {
        super(user, id, publicKey, amount, cuotas, cardNumber, expirationDate, cvv);
    }

    public long getCifEmperador() {
        return cifradoEmperador.cifrar(this.getCardNumber(), 3);
    }

    @Override
    public void cambiar_pasarela(Pasarela_Pago nuevaPasarela) {
    }

    @Override
    public void procesar_pago() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'procesar_pago'");
    }

}
