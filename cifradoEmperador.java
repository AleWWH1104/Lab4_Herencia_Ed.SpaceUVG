public class cifradoEmperador {
    
    public static long cifrar(long numero, int desplazamiento) {
        
        String numeroStr = String.valueOf(numero);
        StringBuilder cifrado = new StringBuilder();

        for (int i = 0; i < numeroStr.length(); i++) {
            char digito = numeroStr.charAt(i);
            if (Character.isDigit(digito)) {
                int digitoOriginal = Character.getNumericValue(digito);
                int digitoCifrado = (digitoOriginal + desplazamiento) % 10;
                cifrado.append(digitoCifrado);
            } else {
                cifrado.append(digito);
            }
        }

        return Long.parseLong(cifrado.toString());
    }

}