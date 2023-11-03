import java.util.List;
import java.util.Map;

// Si el primer dígito de la tarjeta es un 5 entonces es una tarjeta Mastercard

public class MasterCard implements Pasarela_Pago {

    @Override
    public void procesar_pago(List<Map<String, Object>> transactions) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'procesar_pago'");
    }

    @Override
    public void cambiar_pasarela(Pasarela_Pago nuevaPasarela) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiar_pasarela'");
    }
    
}

