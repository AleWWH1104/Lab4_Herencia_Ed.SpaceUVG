import java.util.List;
import java.util.Map;

public interface Pasarela_Pago {
    void procesar_pago(List<Map<String, Object>> transactions);

    void cambiar_pasarela(Pasarela_Pago nuevaPasarela);
}
