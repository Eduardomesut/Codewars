package ejercicioslvl4.frequently;

import java.util.*;

public class TopWords {

    public static List<String> top3(String s) {

        HashMap<String, Integer> ranking = new HashMap<>();
        String resultado = s.replaceAll("\\s+", " ").trim();
        String[] palabras = resultado.split(" ");
        for (String palabra:palabras) {
            if (palabra.contains("'") && palabra.matches(".*[a-zA-Z].*")){


            }else {
                if (palabra.contains("'")){
                    palabra = palabra.replaceAll("'", "");
                }
            }
            if (palabra.contains("!")){
                palabra = palabra.replaceAll("!", "");
            }


            if (palabra.contains(" ")){
                palabra = palabra.replaceAll(" ", "");
            }

            if (palabra.contains(",")){
               palabra =  palabra.replaceAll(",", "");
            }
            if (palabra.contains("/")){
                palabra =  palabra.replaceAll("/", "");
            }
            if (palabra.contains("\\")){
                palabra =  palabra.replaceAll("\\\\", "");
            }
            if (palabra.contains(".")){
                palabra =  palabra.replaceAll(".", "");
            }
            if (palabra.contains("#")){
                palabra =  palabra.replaceAll("#", "");
            }
            palabra = palabra.toLowerCase();
            if (!palabra.equals("")){
                if (ranking.containsKey(palabra)){
                    ranking.put(palabra, ranking.get(palabra)+ 1);
                }else {
                    ranking.put(palabra, 1);
                }

            }




        }
        List<String> top = getTopKeys(ranking, 3);

        return top;
    }
    public static List<String> getTopKeys(HashMap<String, Integer> map, int n) {

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));


        List<String> topKeys = new ArrayList<>();
        for (int i = 0; i < Math.min(n, entryList.size()); i++) {
            topKeys.add(entryList.get(i).getKey());
        }

        return topKeys;
    }


}