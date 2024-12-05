package ejercicioslvl6;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Order {
    public static String order(String words) {
        if (words.equals("")){
            return "";
        }
        String [] palabras = words.split(" ");
        if (palabras.length < 2){
            String[] letras = palabras[0].split("");

            for (int i = 0; i < letras.length; i++) {
                if (Character.isDigit((letras[i].charAt(0)))){
                    return palabras[0];
                }
            }
            return "";
        }

        HashMap<Integer, String> orden = new HashMap<>();
        for (int i = 0; i < palabras.length; i++) {
            String[] letras = palabras[i].split("");

            for (int f = 0; f < letras.length; f++) {
                if (Character.isDigit((letras[f].charAt(0)))){
                    orden.put(Integer.parseInt(letras[f]), palabras[i]);
                }
            }

        }
        Map<Integer, String> ordenOrden = new TreeMap<Integer, String>(orden);
        String finalista = "";
        for (Map.Entry<Integer, String> e : ordenOrden.entrySet()){
            finalista += e.getValue() + " ";
        }
        String bien = finalista.substring(0, finalista.length() - 1);
        return bien;
    }

}