/**
 * La clase Transaction representa una transacción financiera con información
 * detallada, como el usuario, el monto, el número de tarjeta y otros detalles
 * relacionados con la transacción.
 *
 * @version 1.0
 * @since [Fecha de Creación]
 */
public class Transaction {
    private String user;
    private long id;
    private String publicKey;
    private double amount;
    private long cuotas;
    private long cardNumber;
    private long expirationDate;
    private long cvv;

    /**
     * Crea una nueva instancia de la clase Transaction con la información de la
     * transacción.
     *
     * @param user           Nombre del usuario que realiza la transacción.
     * @param id             Identificador único de la transacción.
     * @param publicKey      Clave pública para la encriptación de datos.
     * @param amount         Monto de la transacción.
     * @param cuotas         Número de cuotas en las que se divide la transacción.
     * @param cardNumber     Número de la tarjeta de crédito.
     * @param expirationDate Fecha de vencimiento de la tarjeta.
     * @param cvv            Código de seguridad de la tarjeta (CVV).
     */

    public Transaction(String user, long id, String publicKey, double amount, long cuotas, long cardNumber,
            long expirationDate, long cvv) {
        this.user = user;
        this.id = id;
        this.publicKey = publicKey;
        this.amount = amount;
        this.cuotas = cuotas;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    // Métodos getters y setters para acceder y modificar los atributos de la
    // transacción
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getCuotas() {
        return cuotas;
    }

    public void setCuotas(long cuotas) {
        this.cuotas = cuotas;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public long getCvv() {
        return cvv;
    }

    public void setCvv(long cvv) {
        this.cvv = cvv;
    }
}
