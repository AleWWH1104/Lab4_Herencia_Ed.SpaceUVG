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

        MasterCard masterCard = new MasterCard("Usuario", 1, "clavePublica", 100.0, 5123456789012345L, 1231, 123, 6);

        long cifradoEsperado = cifradoEmperador.cifrar(5123456789012345L, 3);

        assertEquals(cifradoEsperado, masterCard.getCifEmperador());
    }

    @Test
    public void testConstructor() {
        // Crea una instancia de MasterCard con valores de ejemplo
        MasterCard masterCard = new MasterCard("Usuario", 1, "clavePublica", 100.0, 5123456789012345L, 1231, 123, 6);

        // Comprueba si los valores de los atributos se han configurado correctamente en el constructor
        assertEquals("Usuario", masterCard.getUser());
        assertEquals(1, masterCard.getId());
        assertEquals("clavePublica", masterCard.getPublicKey());
        assertEquals(100.0, masterCard.getAmount(), 0.001); // Usamos delta para comparar valores de punto flotante
        assertEquals(5123456789012345L, masterCard.getCardNumber());
        assertEquals(1231, masterCard.getExpirationDate());
        assertEquals(123, masterCard.getCvv());
        assertEquals(6, masterCard.getCuotas());
    }
}
