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
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', '|', ' ', ' '},
                {' ', ' ', '|', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '}
        };
        Dinglemouse.line(grid);


    }



    public static boolean line(final char [][] grid) {
        boolean horizontal;
        boolean vertical;
        //Hacer validaciones simples y luego seguir con las complejas
        //Intentar hacer con programación funcional
        horizontal = validateHorizontal(grid);
        vertical = validateVertical(grid);
        // Your code here
        System.out.println(grid.length + " " + grid[0].length);
        return false;
    }

    private static boolean validateHorizontal(final char [][] grid) {
        return false;
    }
    private static boolean validateVertical(final char [][] grid) {
        return false;
    }



}