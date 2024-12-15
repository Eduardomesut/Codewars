package ejercicioslvl4.serpi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snail {

    public static int[] snail(int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return new int[0];
        }


        ArrayList<Integer> snailOrder = new ArrayList<>();


        int top = 0;
        int bottom = array.length - 1;
        int left = 0;
        int right = array[0].length - 1;

        // Recorrido en espiral
        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                snailOrder.add(array[top][i]);
            }
            top++;


            for (int i = top; i <= bottom; i++) {
                snailOrder.add(array[i][right]);
            }
            right--;


            if (top <= bottom) {

                for (int i = right; i >= left; i--) {
                    snailOrder.add(array[bottom][i]);
                }
                bottom--;
            }


            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    snailOrder.add(array[i][left]);
                }
                left++;
            }
        }


        return snailOrder.stream().mapToInt(Integer::intValue).toArray();
    }


    }
