import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    public static void main(String[] args) {
        List<Visa> transaccionesVisa = new ArrayList<>();

        // Crear objetos de Visa y agregarlos a la lista
        Visa transaccion1 = new Visa("Usuario1", 1, "Public1", 100.0, 0, 1234567890123456L, 1224, 123);
        Visa transaccion2 = new Visa("Usuario2", 2, "Public2", 200.0, 0, 2345678901234567L, 0623, 456);

        transaccionesVisa.add(transaccion1);
        transaccionesVisa.add(transaccion2);

        // Generar el archivo XML con la información de las transacciones Visa
        XMLGenerator xmlGenerator = new XMLGenerator();
        xmlGenerator.generarXML(transaccionesVisa, "transacciones_visa.xml");
    }
}
