/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioslvl4.roma;

import java.util.IllegalFormatCodePointException;

/**
 *
 * @author tarde
 */
public class RomanNumerals {

 
  public static String toRoman(int n) {
      int numeroFinal = n;
      String numeroRomano = "";
      if (numeroFinal / 1000 >= 0) {
          int numeroRecorrer = numeroFinal / 1000;
          numeroFinal = numeroFinal % 1000;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "M";
              
          }
      }
      
      if (numeroFinal / 900 >= 0) {
          int numeroRecorrer = numeroFinal / 900;
          numeroFinal = numeroFinal % 900;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "CM";
              
          }
      }
      if (numeroFinal / 500 >= 0) {
          int numeroRecorrer = numeroFinal / 500;
          numeroFinal = numeroFinal % 500;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "D";
              
          }
      }
      if (numeroFinal / 400 >= 0) {
          int numeroRecorrer = numeroFinal / 400;
          numeroFinal = numeroFinal % 400;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "CD";
              
          }
      }
      if (numeroFinal / 100 >= 0) {
          int numeroRecorrer = numeroFinal / 100;
          numeroFinal = numeroFinal % 100;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "C";
              
          }
      }
      if (numeroFinal / 90 >= 0) {
          int numeroRecorrer = numeroFinal / 90;
          numeroFinal = numeroFinal % 90;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "XC";
              
          }
      }
      if (numeroFinal / 50 >= 0) {
          int numeroRecorrer = numeroFinal / 50;
          numeroFinal = numeroFinal % 50;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "L";
              
          }
      }
      if (numeroFinal / 40 >= 0) {
          int numeroRecorrer = numeroFinal / 40;
          numeroFinal = numeroFinal % 40;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "XL";
              
          }
      }
      if (numeroFinal / 10 >= 0) {
          int numeroRecorrer = numeroFinal / 10;
          numeroFinal = numeroFinal % 10;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "X";
              
          }
      }
      if (numeroFinal / 9 >= 0) {
          int numeroRecorrer = numeroFinal / 9;
          numeroFinal = numeroFinal % 9;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "IX";
              
          }
      }
      if (numeroFinal / 5 >= 0) {
          int numeroRecorrer = numeroFinal / 5;
          numeroFinal = numeroFinal % 5;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "V";
              
          }
      }
      if (numeroFinal / 4 >= 0) {
          int numeroRecorrer = numeroFinal / 4;
          numeroFinal = numeroFinal % 4;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "IV";
              
          }
      }
      if (numeroFinal / 1 >= 0) {
          int numeroRecorrer = numeroFinal / 1;
          numeroFinal = numeroFinal % 1;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "I";
              
          }
      }

    return numeroRomano;
  }
  
  public static int fromRoman(String romanNumeral) {

        int numeroFinal = 0;
        String[] partes = romanNumeral.split("");
        int voy = 0;
        if (partes.length > 1){
            if (partes[0].equals("C") && partes[1].equals("M")){
                numeroFinal += 900;
                voy = voy + 2;
            }else if (partes[0].equals("C") && partes[1].equals("D")){
                numeroFinal += 400;
                voy = voy + 2;
            }else if (partes[0].equals("X") && partes[1].equals("C")){
                numeroFinal += 90;
                voy = voy + 2;
            }else if (partes[0].equals("X") && partes[1].equals("L")){
                numeroFinal += 40;
                voy = voy + 2;
            }else if (partes[0].equals("I") && partes[1].equals("X")){
                numeroFinal += 9;
                voy = voy + 2;
            }else if (partes[0].equals("I") && partes[1].equals("V")){
                numeroFinal += 4;
                voy = voy + 2;
            }else if (partes[0].equals("M")){
                numeroFinal += 1000;
                voy ++;
            }else if (partes[0].equals("D")){
                numeroFinal += 500;
                voy ++;
            }else if (partes[0].equals("C")){
                numeroFinal += 100;
                voy ++;
            } else if (partes[0].equals("L")){
                numeroFinal += 50;
                voy ++;
            }
            else if (partes[0].equals("X")){
                numeroFinal += 10;
                voy ++;
            } else if (partes[0].equals("V")){
                numeroFinal += 5;
                voy ++;
            } else if (partes[0].equals("I")){
                numeroFinal += 1;
                voy ++;
            }


        }else{
            if (partes[0].equals("M")){
                numeroFinal += 1000;
            }
            if (partes[0].equals("D")){
                numeroFinal += 500;
            }
            if (partes[0].equals("C")){
                numeroFinal += 100;
            }
            if (partes[0].equals("L")){
                numeroFinal += 50;
            }
            if (partes[0].equals("X")){
                numeroFinal += 10;
            }
            if (partes[0].equals("V")){
                numeroFinal += 5;
            }
            if (partes[0].equals("I")){
                numeroFinal += 1;
            }
            voy ++;
        }

      for (int i = voy; i < partes.length; i++) {
        if (i + 1 < partes.length){
            if (partes[i].equals("C") && partes[i+1].equals("M") || partes[i].equals("C") && partes[i+1].equals("D") ||
                    partes[i].equals("X") && partes[i+1].equals("C") ||
                    partes[i].equals("X") && partes[i+1].equals("L") ||
                    partes[i].equals("I") && partes[i+1].equals("X") || partes[i].equals("I") && partes[i+1].equals("V")){

                if (partes[i].equals("C") && partes[i+1].equals("M")){
                    numeroFinal += 900;

                }
                if (partes[i].equals("C") && partes[i+1].equals("D")){
                    numeroFinal += 400;
                }
                if (partes[i].equals("X") && partes[i+1].equals("C")){
                    numeroFinal += 90;
                }
                if (partes[i].equals("X") && partes[i+1].equals("L")){
                    numeroFinal += 40;
                }
                if (partes[i].equals("I") && partes[i+1].equals("X")){
                    numeroFinal += 9;
                }
                if (partes[i].equals("I") && partes[i+1].equals("V")){
                    numeroFinal += 4;
                }
                i++;

            }else {


                if (partes[i].equals("M")){
                    numeroFinal += 1000;
                }
                if (partes[i].equals("D")){
                    numeroFinal += 500;
                }
                if (partes[i].equals("C")){
                    numeroFinal += 100;
                }
                if (partes[i].equals("L")){
                    numeroFinal += 50;
                }
                if (partes[i].equals("X")){
                    numeroFinal += 10;
                }
                if (partes[i].equals("V")){
                    numeroFinal += 5;
                }
                if (partes[i].equals("I")){
                    numeroFinal += 1;
                }

            }
        }else {
            if (partes[i].equals("M")){
                numeroFinal += 1000;
            }
            if (partes[i].equals("D")){
                numeroFinal += 500;
            }
            if (partes[i].equals("C")){
                numeroFinal += 100;
            }
            if (partes[i].equals("L")){
                numeroFinal += 50;
            }
            if (partes[i].equals("X")){
                numeroFinal += 10;
            }
            if (partes[i].equals("V")){
                numeroFinal += 5;
            }
            if (partes[i].equals("I")){
                numeroFinal += 1;
            }
        }

      }

    return numeroFinal;
  }

}