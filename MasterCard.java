/**
 * La clase MasterCard representa una transacción realizada con una tarjeta Mastercard.
 * Extiende la clase Transaction e incluye métodos específicos para esta tarjeta.
 * 
 * @author David Dominguez
 * @version 1.0
 * @since 2023-11-3
 * 
 */
public class MasterCard extends Transaction {

    /**
     * Crea una nueva instancia de la clase MasterCard con la información de la transacción.
     *
     * @param user          Nombre del usuario que realiza la transacción.
     * @param id            Identificador único de la transacción.
     * @param publicKey     Clave pública para la encriptación de datos.
     * @param amount        Monto de la transacción.
     * @param cardNumber    Número de la tarjeta de crédito.
     * @param expirationDate Fecha de vencimiento de la tarjeta.
     * @param cvv           Código de seguridad de la tarjeta (CVV).
     * @param cuotas        Número de cuotas en las que se divide la transacción.
     */
    public MasterCard(String user, int id, String publicKey, double amount, long cardNumber, int expirationDate, int cvv, int cuotas) {
        super(user, id, publicKey, amount, cuotas, cardNumber, expirationDate, cvv);
    }

    /**
     * Obtiene el cifrado Emperador del número de tarjeta de crédito.
     *
     * @return El número de tarjeta cifrado utilizando el cifrado Emperador.
     */
    public long getCifEmperador() {
        return cifradoEmperador.cifrar(this.getCardNumber(), 3);
    }
}
