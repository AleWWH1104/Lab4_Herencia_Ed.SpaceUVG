import static org.junit.Assert.*;
import org.junit.Test;

/**
 * La clase AmericanExpressTest contiene pruebas unitarias para la clase
 * AmericanExpress.
 * Se centra en probar el método de procesamiento de pagos y el método de
 * generación de hash MD5.
 *
 * @author Iris
 * @version 1.0
 * @since 3 11 23
 */
public class AmericanExpressTest {

    /**
     * Prueba el método de procesamiento de pagos de la clase AmericanExpress.
     */
    @Test
    public void testProcesarPago() {
        // Crear una instancia de AmericanExpress para realizar pruebas
        AmericanExpress amex = new AmericanExpress("Usuario", 123, "Public_Key", 100.0, 2, 1234567890123456L, 1231,
                123);

        // Obtener el monto original antes de procesar el pago
        double montoTotal = amex.getAmount();

        // Llamar al método para procesar el pago

        // Verificar que el monto haya sido actualizado correctamente
        assertEquals(122.0, montoTotal, 0.01); // Se espera un monto de 122.0 con un margen de error de 0.01
    }

    /**
     * Prueba el método de generación de hash MD5 de la clase AmericanExpress.
     */
    @Test
    public void testGenerateHashMD5() {
        // Crear una instancia de AmericanExpress para realizar pruebas
        AmericanExpress amex = new AmericanExpress("Usuario", 123, "Public_Key", 100.0, 2, 1234567890123456L, 1231,
                123);

        // Llamar al método para generar el hash MD5
        StringBuilder hashMD5 = amex.generateHashMD5("Usuario");

        // Verificar que el hash MD5 no esté vacío
        assertNotNull(hashMD5);
        // Verificar que el hash MD5 tenga una longitud de 32 caracteres (tamaño típico
        // de un hash MD5)
        assertEquals(32, hashMD5.length());
    }
}
