package ejercicioslvl3.battleship;

public class BattleField {

    public static boolean fieldValidator(int[][] field) {
        

        int battleship = 0;
        int cruisers = 0;
        int destroyers = 0;
        int submarines = 0;

        for (int filas = 0; filas < field.length; filas++) {
            for (int columnas = 0; columnas < field[filas].length; columnas++) {

                if (field[filas][columnas] != 0) {
                    if (filas == 0 && columnas == 0) {
                        if (field[1][1] != 0) {
                            return false;
                        } else if (field[0][1] != 0) {
                            if (field[1][0] != 0) {
                                return false;
                            } else {
                                field[0][1] += field[filas][columnas];

                            }

                        } else if (field[1][0] != 0) {
                            if (field[0][1] != 0) {
                                return false;
                            } else {
                                field[1][0] += field[filas][columnas];

                            }
                        }

            
                    } else if (filas == 0 && columnas == field[filas].length - 1) {
                        if (field[1][field[filas].length - 2] != 0) {
                            return false;
                        }else if (field[1][field[filas].length - 1] != 0) {
                            if (field[0][field[filas].length - 2] != 0) {
                                return false;
                            }else{

                                field[1][field[filas].length - 1] += field[0][field[filas].length - 1];
                            }
                        }else if (field[0][field[filas].length - 2] != 0) {
                            if (field[1][field[filas].length - 1] != 0){
                                return false;
                            }
                        }
                    } else if (filas == field.length - 1 && columnas == 0) {
                        //Por aquí

                    } else if (filas == field.length - 1 && columnas == field[filas].length - 1) {

                    } else if (filas == field.length - 1) {
                        if (field[filas][columnas + 1] == 1) {
                            if (field[filas + 1][columnas + 1] == 1) {
                                return false;
                            }
                            if (field[filas - 1][columnas + 1] == 1) {
                                return false;
                            }

                        }
                        if (field[filas][columnas - 1] == 1) {

                        }

                    } else if (columnas == field[filas].length - 1) {
                        //Limites

                    } else if (filas == 0) {
                        if (field[0][columnas + 1] != 0){
                            if (field[1][columnas] != 0){
                                return false;
                            }else {

                             field[0][columnas + 1] += field[0][columnas];
                            }
                        }
                        if (field[1][columnas] != 0){
                            if (field[1][columnas + 1] != 0){
                                return false;
                            }else{

                                field[1][columnas] += field[0][columnas];
                            }
                        }
                        
                    } else if (columnas == 0) {

                        if (field[filas + 1][0] != 0){
                            if (field[filas][1] != 0){
                                return false;
                            }else {
                                //field[filas][columnas] += 1;
                                field[filas + 1][0] += field[filas][columnas];
                            }

                        }
                        if (field[filas][1] != 0){
                            if (field[filas + 1][0] != 0){
                                return false;
                            }else{

                                field[filas][1] += field[filas][columnas];
                            }

                        }


                    } else {
                        if (field[filas][columnas + 1] == 1) {

                            if (field[filas][columnas + 1] == 1) {
                                if (field[filas + 1][columnas + 1] == 1) {
                                    return false;
                                }
                                if (field[filas - 1][columnas + 1] == 1) {
                                    return false;
                                }
                            }
                        }
                        if (field[filas][columnas - 1] == 1) {

                        }
                    }

                }

                System.out.print(field[filas][columnas] + " ");
            }
            System.out.println();
        }

        //Calcular barcos
        for (int filas = 0; filas < field.length; filas++) {
            for (int columnas = 0; columnas < field[filas].length; columnas++) {
                
                
                System.out.println(field[filas][columnas] + " ");
                
                if (field[filas][columnas] == 1) {
                    battleship ++;
                    
                }else if (field[filas][columnas] == 2) {
                    cruisers ++;
                }else if (field[filas][columnas] == 3) {


                    destroyers ++;
                }else if (field[filas][columnas] == 4) {
                    submarines++;
                }
                
                System.out.print(field[filas][columnas] + " ");
            }
            System.out.println();
        }
        
        if (battleship != 4) {
            return false;
        }
        if (cruisers != 6) {
            return false;
        }
        if (destroyers != 6) {
            return false;
        }
        if (submarines != 4) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] battleField
                ={{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
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
