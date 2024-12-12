package ejercicioslvl6.bookseller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StockList {

    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        HashMap<String, Integer> ventas = new HashMap<>();
        for (String categ:lstOf1stLetter) {
            ventas.put(categ, 0);
        }
        for (String palabra: lstOfArt) {
            String[] partes = palabra.split(" ");
            int venta = Integer.parseInt(partes[1]);
            String categoria = partes[0];
            if (ventas.containsKey(categoria.charAt(0)+"")){
                ventas.put(categoria.charAt(0)+"", ventas.get(categoria.charAt(0)+"") + venta);
            }
        }
        int sumaVentas = 0;
        String resultado = "";
        for (Map.Entry<String, Integer> entry : ventas.entrySet()) {
            sumaVentas += entry.getValue();
           resultado += "(" + entry.getKey() + " : " + entry.getValue() +") - ";
        }
        if (sumaVentas == 0){
            return "";
        }
        resultado = resultado.substring(0, resultado.length() - 3);
        return resultado;
    }

}
