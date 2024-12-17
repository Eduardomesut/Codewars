package ejercicioslvl3.battleship;

public class BattleField {

    public static boolean fieldValidator(int[][] field) {
        // your code here!



        for (int filas = 0; filas < field.length; filas++) {
            for (int columnas = 0; columnas < field[filas].length; columnas++) {

                if (field[filas][columnas] == 1){
                    if (filas == 0 && columnas == 0){


                    } else if (filas == 0 && columnas == field[filas].length - 1) {

                    } else if (filas == field.length - 1 && columnas == 0) {

                    } else if (filas == field.length - 1 && columnas == field[filas].length - 1) {

                    } else if (filas == field.length - 1){
                        if (field[filas][columnas + 1] == 1){
                            if (field[filas + 1][columnas + 1] == 1){
                                return false;
                            }
                            if (field[filas - 1][columnas + 1] == 1){
                                return false;
                            }

                        }
                        if (field[filas][columnas - 1] == 1){

                        }

                    }else if (columnas == field[filas].length - 1) {
                        //Limites


                    }else{
                        if (field[filas][columnas + 1] == 1){

                            if (field[filas][columnas + 1] == 1){
                                if (field[filas + 1][columnas + 1] == 1){
                                    return false;
                                }
                                if (field[filas - 1][columnas + 1] == 1){
                                    return false;
                                }
                            }
                        }
                        if (field[filas][columnas - 1] == 1){

                        }
                    }



                }

                System.out.print(field[filas][columnas] + " ");
            }
            System.out.println();
        }




        return false;
    }

    public static void main(String[] args) {
        int[][] battleField =
                {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        System.out.println(fieldValidator(battleField));

    }
}