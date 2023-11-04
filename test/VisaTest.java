import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * La clase VisaTest contiene pruebas unitarias para la clase Visa que verifica
 * el procesamiento de pagos y el cambio de pasarela.
 *
 * @author Anggie
 * @version 1.0
 * @since 3 11 23
 */
public class VisaTest {
    private Visa visa;

    @Before
    public void setUp() {
        // Configurar el objeto Visa antes de cada prueba
        visa = new Visa("Usuario1", 1, "Public1", 100.0, 0, 1234567890123456L, 1224, 123);
    }

    /**
     * Prueba el método de procesamiento de pago y verifica que los cálculos de
     * comisión y IVA sean correctos.
     */
    @Test
    public void testProcesarPago() {
        visa.procesar_pago();
        assertEquals(100.0, visa.getOriginalAmount(), 0.01);
        assertEquals(5.0, visa.getServiceFee(), 0.01);
        assertEquals(0.6, visa.getIVA(), 0.01);
        assertEquals(104.4, visa.getTotalAmount(), 0.01);
    }

    /**
     * Prueba el método de cambio de pasarela y verifica que los atributos se
     * actualicen correctamente.
     */
    @Test
    public void testCambioDePasarela() {
        Visa nuevaPasarela = new Visa("Usuario2", 2, "Public2", 200.0, 0, 2345678901234567L, 0623, 456);
        visa.cambiar_pasarela(nuevaPasarela);
        assertEquals("Usuario2", visa.getUser());
        assertEquals(2, visa.getId());
        assertEquals("Public2", visa.getPublicKey());
        assertEquals(200.0, visa.getAmount(), 0.01);
        assertEquals(0, visa.getCuotas());
        assertEquals(2345678901234567L, visa.getCardNumber());
        assertEquals(0623, visa.getExpirationDate());
        assertEquals(456, visa.getCvv());
    }
}
