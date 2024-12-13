/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioslvl4.bowling;

/**
 *
 * @author tarde
 */
public class Solution {

    public static int bowling_score(String frames) {
        int puntuacionAcumulada = 0;
        int puntuacionAcumuladaPleno = 0;
        boolean rachaPleno = false;
        boolean rachaSemi = false;
        int ronda = 0;
        String[] puntuaciones = frames.split(" ");

        for (String puntuacione : puntuaciones) {
            ronda++;
            if (ronda == 10) {
                if (puntuacione.length() > 2) {
                    if (puntuacione.substring(1, 2).equals("/")) {
                        String round = puntuacione.substring(0, 2);
                        puntuacionAcumulada += extraRound(round, rachaPleno, rachaSemi);

                        if (puntuacione.substring(2,puntuacione.length()).contains("X") || puntuacione.substring(2,puntuacione.length()).contains("/")) {

                            //Aquí poner los casos de la ronda extra num 2 con pleno y semipleno
                            
                            
                        }else{
                            round = puntuacione.substring(2, 4);
                            puntuacionAcumulada += extraRound(round, rachaPleno, rachaSemi);
                        }
                    } else {
                        String round = puntuacione.substring(0, 1);
                        puntuacionAcumulada += extraRound(round, rachaPleno, rachaSemi);

                        if (true) {

                        }

                    }

                } else {
                    if (rachaPleno) {
                        rachaPleno = false;
                        puntuacionAcumulada += (Integer.parseInt(puntuacione.substring(0, 1)) + Integer.parseInt(puntuacione.substring(1, 2))
                                + Integer.parseInt(puntuacione.substring(0, 1)) + Integer.parseInt(puntuacione.substring(1, 2)) + puntuacionAcumuladaPleno);

                        puntuacionAcumuladaPleno = 0;

                    } else if (rachaSemi) {
                        rachaSemi = false;
                        puntuacionAcumulada += (Integer.parseInt(puntuacione.substring(0, 1)) + Integer.parseInt(puntuacione.substring(1, 2)) + Integer.parseInt(puntuacione.substring(0, 1)) + puntuacionAcumuladaPleno);
                        puntuacionAcumuladaPleno = 0;
                    } else {
                        puntuacionAcumulada += (Integer.parseInt(puntuacione.substring(0, 1)) + Integer.parseInt(puntuacione.substring(1, 2)));
                    }

                }

            } else {
                if (puntuacione.contains("/")) {

                    if (rachaPleno) {
                        rachaPleno = false;
                        rachaSemi = true;
                        puntuacionAcumulada += 10 + 10 + puntuacionAcumuladaPleno;
                        puntuacionAcumuladaPleno = 10;

                    } else if (rachaSemi) {
                        rachaSemi = true;
                        puntuacionAcumulada += 10 + 10 + puntuacionAcumuladaPleno;
                        puntuacionAcumuladaPleno = 10;
                    } else {
                        rachaSemi = true;
                        puntuacionAcumuladaPleno = 10;
                    }

                } else if (puntuacione.contains("X")) {
                    if (rachaPleno) {
                        rachaPleno = true;
                        puntuacionAcumulada += 10 + 10 + puntuacionAcumuladaPleno;
                        puntuacionAcumuladaPleno = 10;

                    } else if (rachaSemi) {
                        rachaSemi = false;
                        rachaPleno = true;
                        puntuacionAcumulada += 10 + 10 + puntuacionAcumuladaPleno;
                        puntuacionAcumuladaPleno = 10;
                    } else {
                        rachaPleno = true;
                        puntuacionAcumuladaPleno = 10;
                    }

                } else {
                    if (rachaPleno) {
                        rachaPleno = false;
                        puntuacionAcumulada += (Integer.parseInt(puntuacione.substring(0, 1)) + Integer.parseInt(puntuacione.substring(1, 2))
                                + Integer.parseInt(puntuacione.substring(0, 1)) + Integer.parseInt(puntuacione.substring(1, 2)) + puntuacionAcumuladaPleno);

                        puntuacionAcumuladaPleno = 0;

                    } else if (rachaSemi) {
                        rachaSemi = false;
                        puntuacionAcumulada += (Integer.parseInt(puntuacione.substring(0, 1)) + Integer.parseInt(puntuacione.substring(1, 2)) + Integer.parseInt(puntuacione.substring(0, 1)) + puntuacionAcumuladaPleno);
                        puntuacionAcumuladaPleno = 0;
                    } else {
                        puntuacionAcumulada += (Integer.parseInt(puntuacione.substring(0, 1)) + Integer.parseInt(puntuacione.substring(1, 2)));
                    }

                }
            }

        }

        return puntuacionAcumulada;
    }

    public static int extraRound(String puntuacione, boolean rachaPleno, boolean rachaSemi) {
        int puntuacionAcumulada = 0;

        if (puntuacione.contains("/")) {

            if (rachaPleno) {
                rachaPleno = false;
                rachaSemi = true;
                puntuacionAcumulada += 10 + 10 + 10;

            } else if (rachaSemi) {
                rachaSemi = true;
                puntuacionAcumulada += 10 + 10 + 10;

            } else {
                rachaSemi = true;

            }

        } else if (puntuacione.contains("X")) {
            if (rachaPleno) {
                rachaPleno = true;
                puntuacionAcumulada += 10 + 10 + 10;

            } else if (rachaSemi) {
                rachaSemi = false;
                rachaPleno = true;
                puntuacionAcumulada += 10 + 10 + 10;

            } else {
                rachaPleno = true;

            }

        } else {
            if (rachaPleno) {
                rachaPleno = false;
                puntuacionAcumulada += (Integer.parseInt(puntuacione.substring(0, 1)) + Integer.parseInt(puntuacione.substring(1, 2))
                        + Integer.parseInt(puntuacione.substring(0, 1)) + Integer.parseInt(puntuacione.substring(1, 2)) + 10);

            } else if (rachaSemi) {
                rachaSemi = false;
                puntuacionAcumulada += (Integer.parseInt(puntuacione.substring(0, 1)) + Integer.parseInt(puntuacione.substring(1, 2)) + Integer.parseInt(puntuacione.substring(0, 1)) + 10);

            } else {
                puntuacionAcumulada += (Integer.parseInt(puntuacione.substring(0, 1)) + Integer.parseInt(puntuacione.substring(1, 2)));
            }

        }

        return puntuacionAcumulada;
    }

    public static void main(String[] args) {
        System.out.println(bowling_score("00 00 60 03 4/ X 02 00 9/ 70"));
        System.out.println(bowling_score("X X X X X X X X X 11"));
        System.out.println(bowling_score("9/ 54"));
        System.out.println(bowling_score("11 11 11 11 11 11 11 11 11 11"));

    }

}
