import static org.junit.Assert.*;
import org.junit.Test;
public class AmericanExpressTest {
    
    @Test
    public void testProcesarPago() {
        // Crear una instancia de AmericanExpress para realizar pruebas
        AmericanExpress amex = new AmericanExpress("Usuario", 123, "Public_Key", 100.0, 2, 1234567890, 1231, 123);

        // Obtener el monto original antes de procesar el pago
        double montoOriginal = amex.getAmount();

        // Llamar al método para procesar el pago
        amex.procesar_pago();

        // Verificar que el monto haya sido actualizado correctamente
        assertEquals(107.0, amex.getAmount(), 0.01); // Se espera un monto de 107.0 con un margen de error de 0.01
    }

    @Test
    public void testGenerateHashMD5() {
        // Crear una instancia de AmericanExpress para realizar pruebas
        AmericanExpress amex = new AmericanExpress("Usuario", 123, "Public_Key", 100.0, 2, 1234567890, 1231, 123);

        // Llamar al método para generar el hash MD5
        StringBuilder hashMD5 = amex.generateHashMD5("Usuario");

        // Verificar que el hash MD5 no esté vacío
        assertNotNull(hashMD5);
        // Verificar que el hash MD5 tenga una longitud de 32 caracteres (tamaño típico de un hash MD5)
        assertEquals(32, hashMD5.length());
    }
}

