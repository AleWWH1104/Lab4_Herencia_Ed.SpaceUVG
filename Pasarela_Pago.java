public interface Pasarela_Pago {
    void procesar_pago();
    void cambiar_pasarela(Pasarela_Pago nuevaPasarela);
}
