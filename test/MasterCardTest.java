import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * La clase MasterCardTest contiene pruebas unitarias para la clase MasterCard.
 *
 * @author David Dominguez
 * @version 1.0
 * @since 2023-11-3
 */
public class MasterCardTest {

    @Test
    public void testGetCifEmperador() {

        // String user, int id, String publicKey, double amount, int cuotas, long
        // cardNumber, int expirationDate, int cvv
        MasterCard masterCard = new MasterCard("Usuario", 1, "clavePublica", 100.0, 12, 5123456789012345L, 1212, 123);

        long cifradoEsperado = cifradoEmperador.cifrar(5123456789012345L, 3);

        assertEquals(cifradoEsperado, masterCard.getCifEmperador());
    }

    @Test
    public void testConstructor() {
        // Crea una instancia de MasterCard con valores de ejemplo
        MasterCard masterCard = new MasterCard("Usuario", 1, "clavePublica", 100.0, 12, 5123456789012345L, 1212, 123);

        // Comprueba si los valores de los atributos se han configurado correctamente en
        // el constructor
        assertEquals("Usuario", masterCard.getUser());
        assertEquals(1, masterCard.getId());
        assertEquals("clavePublica", masterCard.getPublicKey());
        assertEquals(100.0, masterCard.getAmount(), 0.001); // Usamos delta para comparar valores de punto flotante
        assertEquals(5123456789012345L, masterCard.getCardNumber());
        assertEquals(1212, masterCard.getExpirationDate());
        assertEquals(123, masterCard.getCvv());
        assertEquals(12, masterCard.getCuotas());
    }
}
