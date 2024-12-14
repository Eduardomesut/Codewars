package ejercicioslvl4.bird;

import java.util.Arrays;

public class Dinglemouse {

    public static int[] dryGround(char[][] terrain) {



        // Your code here
        return new int[]{0,0,0,0};
    }

    public static void main(String[] args) {
        char[][] terrain = {
                "  ^^^^^^             ".toCharArray(),
                "^^^^^^^^       ^^^   ".toCharArray(),
                "^^^^^^^  ^^^         ".toCharArray(),
                "^^^^^^^  ^^^         ".toCharArray(),
                "^^^^^^^  ^^^         ".toCharArray(),
                "---------------------".toCharArray(),
                "^^^^^                ".toCharArray(),
                "   ^^^^^^^^  ^^^^^^^ ".toCharArray(),
                "^^^^^^^^     ^     ^ ".toCharArray(),
                "^^^^^        ^^^^^^^ ".toCharArray()
        };

        int[]dias = dryGround(terrain);
        System.out.println(Arrays.toString(dias));


    }

}
