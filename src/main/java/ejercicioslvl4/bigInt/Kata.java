package ejercicioslvl4.bigInt;

import java.math.BigInteger;

public class Kata {
    public static String sumStrings(String a, String b) {

        int numa = Integer.parseInt(a);
        int numb = Integer.parseInt(b);
        int suma = numa+numb;
        String resultado = String.valueOf(suma);

        return resultado;
    }
}