package ejercicioslvl3.lineSafari;

public class Dinglemouse {

    /* VALIDO
    "                    ",
    "     +--------+     ",
    "  X--+        +--+  ",
    "                 |  ",
    "                 X  ",
    "
     */


    public static void main(String[] args) {
        char[][] grid = {
                {'X', '-', 'X', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '}
        };

        System.out.println(Dinglemouse.line(grid));


    }



    public static boolean line(final char [][] grid) {
        boolean horizontal;
        boolean vertical;
        //Hacer validaciones simples y luego seguir con las complejas
        //Intentar hacer con programación funcional

        return validateHorizontal(grid);
    }

    private static boolean validateHorizontal(final char [][] grid) {
        //Aquí tengo el validador de X para comprobar que sean 2


        int contadorX = 0;
        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
                //Si el horizontal es -
                if(grid[i][j] == '-'){
                    if (j == grid[i].length - 1 || j == 0) {
                        System.out.println("error 1");
                        return false;
                    }else {
                        if (grid[i][j-1] == '|' || grid[i][j+1] == '|') {
                            System.out.println("error 2");
                            return false;
                        }
                        if (grid[i][j-1] == ' ' || grid[i][j+1] == ' ') {
                            System.out.println("error 3");
                            return false;
                        }

                    }

                } else if (grid[i][j] == '|') {
                    if (j == grid[i].length - 1) {
                        if (grid[i][j-1] == '-') {
                            System.out.println("error 4");
                            return false;
                        }
                    } else if (j == 0) {
                        if (grid[i][j+1] == '-') {
                            System.out.println("error 5");
                            return false;
                        }
                    }

                    //intentar hacerlo por mi cuebnta con ifs
                    char arriba = (i > 0) ? grid[i - 1][j] : ' ';
                    char abajo  = (i < grid.length - 1) ? grid[i + 1][j] : ' ';

                    if (arriba == '-' || abajo == '-' || arriba == ' ' || abajo == ' ') {
                        System.out.println("Error arriba o abajo");
                        System.out.println("Error arriba o abajo");
                        return false;
                    }

                    //ESTO NO ESTA DEL TODO BIEN FALTAN CORREGIR COSAS
                } else if (grid[i][j] == 'X') {
                    if (i == grid.length - 1) {
                        //System.out.println(grid[i-1][j]);
                        //Primera y última posicion de la ultima fila
                        if (j == grid[i].length - 1) {
                            if ((grid[i][j-1] != '-' && grid[i][j-1] != 'X' && grid[i][j-1] != '+') && grid[i-1][j] != '|' && grid[i-1][j] != '+' && grid[i-1][j] != 'X'){
                                return false;
                            }
                        }else if (j == 0){
                            if ((grid[i][j+1] != '-' && grid[i][j+1] != 'X' && grid[i][j+1] != '+') && grid[i-1][j] != '|' && grid[i-1][j] != '+' && grid[i-1][j] != 'X'){
                                return false;
                            }

                        }else {
                            if ((grid[i][j+1] != '-' && grid[i][j+1] != 'X' && grid[i][j+1] != '+' &&  grid[i][j-1] != '-' && grid[i][j-1] != 'X' && grid[i][j-1] != '+') && grid[i-1][j] != '|' && grid[i-1][j] != '+' && grid[i-1][j] != 'X') {
                                System.out.println("Error 5");
                                System.out.println(grid[i][j-1]);
                                return false;
                            }
                        }

                        //Primera fila
                    } else if (i == 0) {
                        if (j == grid[i].length - 1) {
                            if ((grid[i][j-1] != '-' && grid[i][j-1] != 'X' && grid[i][j-1] != '+') && grid[i+1][j] != '|' && grid[i+1][j] != '+' && grid[i+1][j] != 'X'){
                                return false;
                            }
                        }else if (j == 0){
                            if ((grid[i][j+1] != '-' && grid[i][j+1] != 'X' && grid[i][j+1] != '+') && grid[i+1][j] != '|' && grid[i+1][j] != '+' && grid[i+1][j] != 'X'){
                                return false;
                            }

                        }else {
                            if ((grid[i][j+1] != '-' && grid[i][j+1] != 'X' && grid[i][j+1] != '+' &&  grid[i][j-1] != '-' && grid[i][j-1] != 'X' && grid[i][j-1] != '+') && grid[i+1][j] != '|' && grid[i+1][j] != '+' && grid[i+1][j] != 'X') {
                                System.out.println("Error 6");
                                System.out.println(grid[i][j]);
                                System.out.println(grid[i][j-1]);
                                return false;
                            }
                        }
                        //Ultima columna
                    }else if (j == grid[i].length - 1) {
                        if ((grid[i][j-1] != '-' && grid[i][j-1] != 'X') && (grid[i+1][j] != '|' && grid[i+1][j] != 'X' && grid[i-1][j] != '|' && grid[i-1][j] != 'X')){
                            return false;
                        }

                        //Primera columna
                    }else if (j == 0) {
                        if ((grid[i][j+1] != '-' && grid[i][j+1] != 'X') && (grid[i+1][j] != '|' && grid[i+1][j] != 'X' && grid[i-1][j] != '|' && grid[i-1][j] != 'X')){
                            return false;
                        }
                    }else {
                        //Creo que para los normales el validador sería que cuando hay un + en alguna de los subyacentes este el -,| o X, aparte de estar con otra + necesita pasar por un - o |
                        if ((grid[i][j+1] != '-' && grid[i][j+1] != 'X' && grid [i][j+1] != '+' && grid [i][j-1] != '-' && grid [i][j-1] != 'X' && grid [i][j-1] != '+')
                                && (grid[i+1][j] != '|' && grid[i+1][j] != 'X' && grid[i+1][j] != '+' && grid[i-1][j] != '|' && grid[i-1][j] != 'X' && grid[i-1][j] != '+')
                                || (grid[i][j+1] == '-' && (grid[i][j-1] == '-') || (grid[i-1][j] == '|') && (grid[i+1][j] == '|'))) {
                            return false;
                        }
                    }
                    contadorX ++;
                } else if (grid[i][j] == '+') {
                    //TODO
                    //Ultima fila

                    if (i == grid.length - 1) {
                        System.out.println(grid[i-1][j]);
                        //Primera y última posicion de la ultima fila
                        if (j == grid[i].length - 1) {
                            if ((grid[i][j-1] != '-' && grid[i][j-1] != 'X' && grid[i][j-1] != '+') || grid[i-1][j] != '|' && grid[i-1][j] != '+' && grid[i-1][j] != 'X'){
                                return false;
                            }
                        }else if (j == 0){
                            if ((grid[i][j+1] != '-' && grid[i][j+1] != 'X' && grid[i][j+1] != '+') || grid[i-1][j] != '|' && grid[i-1][j] != '+' && grid[i-1][j] != 'X'){
                                return false;
                            }

                        }else {
                            if ((grid[i][j+1] != '-' && grid[i][j+1] != 'X' && grid[i][j+1] != '+' &&  grid[i][j-1] != '-' && grid[i][j-1] != 'X' && grid[i][j-1] != '+') || grid[i-1][j] != '|' && grid[i-1][j] != '+' && grid[i-1][j] != 'X') {
                                System.out.println("Error 5");
                                System.out.println(grid[i][j-1]);
                                return false;
                            }
                        }

                    //Primera fila
                    } else if (i == 0) {
                        if (j == grid[i].length - 1) {
                            if ((grid[i][j-1] != '-' && grid[i][j-1] != 'X' && grid[i][j-1] != '+') || grid[i+1][j] != '|' && grid[i+1][j] != '+' && grid[i+1][j] != 'X'){
                                return false;
                            }
                        }else if (j == 0){
                            if ((grid[i][j+1] != '-' && grid[i][j+1] != 'X' && grid[i][j+1] != '+') || grid[i+1][j] != '|' && grid[i+1][j] != '+' && grid[i+1][j] != 'X'){
                                return false;
                            }

                        }else {
                            if ((grid[i][j+1] != '-' && grid[i][j+1] != 'X' && grid[i][j+1] != '+' &&  grid[i][j-1] != '-' && grid[i][j-1] != 'X' && grid[i][j-1] != '+') || grid[i+1][j] != '|' && grid[i+1][j] != '+' && grid[i+1][j] != 'X') {
                                System.out.println("Error 6");
                                System.out.println(grid[i][j]);
                                System.out.println(grid[i][j-1]);
                                return false;
                            }
                        }
                    //Ultima columna
                    }else if (j == grid[i].length - 1) {
                    return false;



                    //Primera columna
                    }else if (j == 0) {
                        return false;

                    }else {
                        //Creo que para los normales el validador sería que cuando hay un + en alguna de los subyacentes este el -,| o X, aparte de estar con otra + necesita pasar por un - o |
                        if ((grid[i][j+1] != '-' && grid[i][j+1] != 'X' && grid [i][j+1] != '+' && grid [i][j-1] != '-' && grid [i][j-1] != 'X' && grid [i][j-1] != '+')
                                || (grid[i+1][j] != '|' && grid[i+1][j] != 'X' && grid[i+1][j] != '+' && grid[i-1][j] != '|' && grid[i-1][j] != 'X' && grid[i-1][j] != '+')
                                || (grid[i][j+1] == '-' && (grid[i][j-1] == '-') || (grid[i-1][j] == '|') && (grid[i+1][j] == '|'))) {
                            return false;
                        }
                        if (grid[i-1][j-1] == '+' && grid[i][j-1] == '+' && grid[i-1][j] == '+' && grid[i][j+1] == '+' && grid[i+1][j] == '+' && grid[i +1][j+1] == '+'
                        && grid[i-1][j+1] == '+' && grid[i+1][j-1] == '+'){
                            return false;
                        }
                    }
                }

            }
        }
        if (contadorX != 2){
            return false;
        }
        System.out.println();
        return true;
    }

    //Hacer un buble contrario recorriendo los verticales y validando el de arriba y el de abajo y los corners
    private static boolean validateVertical(final char [][] grid) {
        return false;
    }



}