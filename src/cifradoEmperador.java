/**
 * La clase cifradoEmperador proporciona un método estático para cifrar un
 * número entero utilizando el cifrado Emperador.
 * 
 * @author David
 * @version 1.0
 * @since 3 11 23
 */
public class cifradoEmperador {

    /**
     * Cifra un número entero utilizando el cifrado Emperador con un desplazamiento
     * especificado.
     *
     * @param numero         El número entero que se va a cifrar.
     * @param desplazamiento El valor de desplazamiento para el cifrado.
     * @return Un número entero cifrado utilizando el cifrado Emperador.
     */
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
