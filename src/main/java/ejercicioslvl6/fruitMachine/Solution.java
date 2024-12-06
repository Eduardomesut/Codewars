package ejercicioslvl6.fruitMachine;

public class Solution {
    public static int fruit(final String[][] reels, final int[] spins) {
        String figura1;
        String figura2;
        String figura3;

        figura1 = reels[0][spins[0]];
        figura2 = reels[1][spins[1]];
        figura3 = reels[2][spins[2]];
        int resultado = 0;

        if (figura1.equals(figura2) & figura1.equals(figura3)){
            resultado = sacarPuntioacionTriple(figura1, figura2, figura3);

        } else if (figura1.equals(figura2) & !figura3.equals("Wild")) {
            resultado = sacarPuntioacionDoble(figura1, figura2);
        } else if (figura2.equals(figura3) & !figura1.equals("Wild")) {
            resultado = sacarPuntioacionDoble(figura2, figura3);
        } else if (figura1.equals(figura2) & figura3.equals("Wild")) {
            resultado = sacarPuntioacionDobleWild(figura1, figura2);
        } else if (figura2.equals(figura3) & figura1.equals("Wild")) {
            resultado = sacarPuntioacionDobleWild(figura2, figura3);
        }else if (figura1.equals(figura3) & figura2.equals("Wild")) {
            resultado = sacarPuntioacionDobleWild(figura1, figura3);
        }else if (figura1.equals(figura3) & !figura2.equals("Wild")) {
            resultado = sacarPuntioacionDoble(figura1, figura3);
        }
        return resultado;
    }

    private static int sacarPuntioacionDobleWild(String figura1, String figura2) {
        if (figura1.equals("Wild")){
            return 100;
        } else if (figura1.equals("Star")) {
            return 18;
        }else if (figura1.equals("Bell")) {
            return 16;
        }else if (figura1.equals("Shell")) {
            return 14;
        }else if (figura1.equals("Seven")) {
            return 12;
        }else if (figura1.equals("Cherry")) {
            return 10;
        }else if (figura1.equals("Bar")) {
            return 8;
        }else if (figura1.equals("King")) {
            return 6;
        }else if (figura1.equals("Queen")) {
            return 4;
        }else if (figura1.equals("Jack")) {
            return 2;
        }

        return 0;
    }

    private static int sacarPuntioacionDoble(String figura1, String figura2) {
        if (figura1.equals("Wild")){
            return 10;
        } else if (figura1.equals("Star")) {
            return 9;
        }else if (figura1.equals("Bell")) {
            return 8;
        }else if (figura1.equals("Shell")) {
            return 7;
        }else if (figura1.equals("Seven")) {
            return 6;
        }else if (figura1.equals("Cherry")) {
            return 5;
        }else if (figura1.equals("Bar")) {
            return 4;
        }else if (figura1.equals("King")) {
            return 3;
        }else if (figura1.equals("Queen")) {
            return 2;
        }else if (figura1.equals("Jack")) {
            return 1;
        }

        return 0;
    }




    private static int sacarPuntioacionTriple(String figura1, String figura2, String figura3) {
        if (figura1.equals("Wild")){
            return 100;
        } else if (figura1.equals("Star")) {
            return 90;
        }else if (figura1.equals("Bell")) {
            return 80;
        }else if (figura1.equals("Shell")) {
            return 70;
        }else if (figura1.equals("Seven")) {
            return 60;
        }else if (figura1.equals("Cherry")) {
            return 50;
        }else if (figura1.equals("Bar")) {
            return 40;
        }else if (figura1.equals("King")) {
            return 30;
        }else if (figura1.equals("Queen")) {
            return 20;
        }else if (figura1.equals("Jack")) {
            return 10;
        }

    return 0;
    }
}

