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

}
