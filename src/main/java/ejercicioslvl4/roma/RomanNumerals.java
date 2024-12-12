/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioslvl4.roma;

/**
 *
 * @author tarde
 */
public class RomanNumerals {
    
//    +--------+-------+
//| Symbol | Value |
//+--------+-------+
//|    M   |  1000 |
//|   CM   |   900 |
//|    D   |   500 |
//|   CD   |   400 |
//|    C   |   100 |
//|   XC   |    90 |
//|    L   |    50 |
//|   XL   |    40 |
//|    X   |    10 |
//|   IX   |     9 |
//|    V   |     5 |
//|   IV   |     4 |
//|    I   |     1 |
//+--------+-------+
 
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
          numeroFinal = numeroFinal % 1000;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "CD";
              
          }
      }
      if (numeroFinal / 100 >= 0) {
          int numeroRecorrer = numeroFinal / 100;
          numeroFinal = numeroFinal % 1000;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "C";
              
          }
      }
      if (numeroFinal / 90 >= 0) {
          int numeroRecorrer = numeroFinal / 90;
          numeroFinal = numeroFinal % 1000;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "XC";
              
          }
      }
      if (numeroFinal / 50 >= 0) {
          int numeroRecorrer = numeroFinal / 50;
          numeroFinal = numeroFinal % 1000;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "L";
              
          }
      }
      if (numeroFinal / 40 >= 0) {
          int numeroRecorrer = numeroFinal / 1000;
          numeroFinal = numeroFinal % 1000;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "XL";
              
          }
      }
      if (numeroFinal / 10 >= 0) {
          int numeroRecorrer = numeroFinal / 1000;
          numeroFinal = numeroFinal % 1000;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "X";
              
          }
      }
      if (numeroFinal / 9 >= 0) {
          int numeroRecorrer = numeroFinal / 1000;
          numeroFinal = numeroFinal % 1000;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "IX";
              
          }
      }
      if (numeroFinal / 5 >= 0) {
          int numeroRecorrer = numeroFinal / 1000;
          numeroFinal = numeroFinal % 1000;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "V";
              
          }
      }
      if (numeroFinal / 4 >= 0) {
          int numeroRecorrer = numeroFinal / 1000;
          numeroFinal = numeroFinal % 1000;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "IV";
              
          }
      }
      if (numeroFinal / 1 >= 0) {
          int numeroRecorrer = numeroFinal / 1000;
          numeroFinal = numeroFinal % 1000;
          for (int i = 0; i < numeroRecorrer; i++) {
              numeroRomano += "I";
              
          }
      }
      
      
      
      
      
    return numeroRomano;
  }
  
  public static int fromRoman(String romanNumeral) {
      
      
      
      
      
    return 1;
  }
}