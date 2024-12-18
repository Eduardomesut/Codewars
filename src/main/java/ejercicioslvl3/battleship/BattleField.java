package ejercicioslvl3.battleship;

public class BattleField {
    
    public static boolean fieldValidator(int[][] field) {
        
        int battleship = 0;
        int cruisers = 0;
        int destroyers = 0;
        int submarines = 0;
        
        int rows = field.length;
        int cols = field[0].length;
        
        int[][] borderedField = new int[rows + 2][cols + 2];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                borderedField[i + 1][j + 1] = field[i][j];
            }
        }
        
        for (int filas = 0; filas < borderedField.length; filas++) {
            for (int columnas = 0; columnas < borderedField[filas].length; columnas++) {
                
                if (borderedField[filas][columnas] != 0) {
                    if (borderedField[filas - 1][columnas -1] != 0) {
                       return false; 
                    }
                    if (borderedField[filas + 1][columnas + 1] != 0) {
                        return false;
                    }
                    if (borderedField[filas - 1][columnas + 1] != 0) {
                        return false;
                    }
                    if (borderedField[filas - 1][columnas + 1] != 0) {
                        return false;
                    }
                    
                    if (borderedField[filas][columnas + 1] != 0) {
                        if (borderedField[filas + 1][columnas] != 0) {
                            return false;
                        }else{
                            borderedField[filas][columnas + 1] += borderedField[filas][columnas];
                        }
                        
                        
                    }
                    if (borderedField[filas + 1][columnas] != 0) {
                            if (borderedField[filas][columnas + 1] != 0) {
                                return false;
                            }else{
                                borderedField[filas + 1][columnas] += borderedField[filas][columnas];
                            }
                        }
                    
                }
                
            }
            
        }

        //Calcular barcos
        for (int filas = 0; filas < borderedField.length; filas++) {
            for (int columnas = 0; columnas < borderedField[filas].length; columnas++) {
                
                if (borderedField[filas][columnas] == 1) {
                    battleship++;
                    
                } else if (borderedField[filas][columnas] == 2) {
                    cruisers++;
                } else if (borderedField[filas][columnas] == 3) {
                    
                    destroyers++;
                } else if (borderedField[filas][columnas] == 4) {
                    submarines++;
                }
                
               
            }
          
        }
        
       
        if (battleship != 10) {
            return false;
        }
        if (cruisers != 6) {
            return false;
        }
        if (destroyers != 3) {
            return false;
        }
        if (submarines != 1) {
            return false;
        }
        return true;
    }
    
}
