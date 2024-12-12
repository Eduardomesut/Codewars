/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioslvl5.pig_latin;

/**
 *
 * @author tarde
 */
public class PigLatin {

    public static String pigIt(String str) {
        String fraseCambiada = "";
        String[] separador = str.split(" ");
        for (String string : separador) {
            if (string.equals("!") || string.equals("?")) {
                fraseCambiada += string + " ";
            } else {
                Character primero = string.charAt(0);
                string = string.substring(1, string.length()) + primero + "ay";

                fraseCambiada += string + " ";
            }

        }
        fraseCambiada = fraseCambiada.substring(0,fraseCambiada.length()-1);
        return fraseCambiada;
    }

    
}




//public static void main(String[] args) {
//
//        String palabra = "Pig latin is cool !";
//        System.out.println(pigIt(palabra));
//
//    }