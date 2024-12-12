/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioslvl5.pete;

/**
 *
 * @author tarde
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PeteBaker {

    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        // Tengo que retornart las tartas que puede hacer Pete
        int tartasPosibles = 0;
        int ingredientes = recipe.size();
        int ingredientesTengo = 0;
        List<Integer> posibilidades = new ArrayList<>();
        int microTarta = 0;
        for (Map.Entry<String, Integer> entry : recipe.entrySet()) {
            if (available.containsKey(entry.getKey())) {
                if (available.get(entry.getKey()) >= entry.getValue()) {
                    ingredientesTengo ++;
                }else{
                    
                }
                
                if (available.get(entry.getKey()) / entry.getValue() > 0) {
                    posibilidades.add(available.get(entry.getKey()) / entry.getValue()) ;
                }      
            }
        }
        if (ingredientesTengo == ingredientes) {
            tartasPosibles = Collections.min(posibilidades);
            return tartasPosibles;
            
        }else{
            return 0;
        }

    }
}
