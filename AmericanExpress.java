import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * La clase AmericanExpress representa una transacción realizada con una tarjeta
 * American Express.
 * Extiende la clase Transaction e implementa la interfaz Pasarela_Pago.
 * Proporciona métodos para procesar el pago y generar un hash MD5 a partir del
 * nombre de usuario.
 *
 * @author [Tu Nombre]
 * @version 1.0
 * @since [Fecha de Creación]
 */
public class AmericanExpress extends Transaction implements Pasarela_Pago {
    private StringBuilder hashMD5;

    /**
     * Crea una nueva instancia de la clase AmericanExpress con la información de la
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
    public AmericanExpress(String user, long id, String publicKey, double amount, long cuotas, long cardNumber,
            long expirationDate, long cvv) {
        super(user, id, publicKey, amount, cuotas, cardNumber, expirationDate, cvv);
        this.hashMD5 = generateHashMD5(user);
        procesar_pago();
    }

    /**
     * Obtiene el hash MD5 generado a partir del nombre de usuario.
     *
     * @return Un StringBuilder que contiene el hash MD5 en formato hexadecimal.
     */
    public StringBuilder getHashMD5() {
        return hashMD5;
    }

    /**
     * Procesa el pago y ajusta el monto de la transacción según las reglas de
     * American Express.
     */
    @Override
    public void procesar_pago() {
        double montoOriginal = this.getAmount();
        double servicio = 0.07 * montoOriginal;
        long cuotas = this.getCuotas();
        if (cuotas > 1) {
            servicio += 0.15 * montoOriginal;
        }
        double nuevoMonto = montoOriginal + servicio;
        this.setAmount(nuevoMonto);
    }

    /**
     * Genera un hash MD5 a partir de una cadena de entrada.
     *
     * @param input La cadena de entrada para la cual se calculará el hash MD5.
     * @return Un StringBuilder que contiene el hash MD5 en formato hexadecimal.
     */
    public StringBuilder generateHashMD5(String input) {
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

    /**
     * Cambia la pasarela de pago a una nueva pasarela.
     *
     * @param nuevaPasarela La nueva pasarela de pago a utilizar.
     */
    @Override
    public void cambiar_pasarela(Pasarela_Pago nuevaPasarela) {
        // Implementa el cambio de pasarela aquí, si es necesario.
    }
}
