/**
 * La interfaz Pasarela_Pago define un contrato para procesar pagos y cambiar la
 * pasarela de pago.
 *
 * @version 1.0
 * @author Anggie
 * @since 3 11 23
 */
public interface Pasarela_Pago {

    /**
     * Procesa el pago de acuerdo a las reglas de la pasarela de pago.
     */
    void procesar_pago();

    /**
     * Cambia la pasarela de pago a una nueva pasarela especificada.
     *
     * @param nuevaPasarela La nueva pasarela de pago a utilizar.
     */
    void cambiar_pasarela(Pasarela_Pago nuevaPasarela);
}
