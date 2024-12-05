//To do only part 1, comment out any code to do with the dampner

package D2;

import java.util.Scanner;
import java.util.Arrays;

public class D2 {
    public static void runD2P1 (){

        Scanner scanner = new Scanner(System.in);

        int safeNum = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                break;
            }
            
            String[] numbersString = line.split(" ");
            int[] numbers = Arrays.stream(numbersString).mapToInt(Integer::parseInt).toArray();
            
            //dampner
            if (isSafe(numbers) || isDampnerSafe(numbers)) {
                safeNum++;
            }
        }

        
        System.out.println(safeNum);
        scanner.close();
    }

    private static boolean isSafe(int[] array) {
        
        if (!(isSorted(array) || isInverseSorted(array))) {
            return false;
        }
        
        for (int i = 0; i < array.length - 1; i++) {
            int n = Math.abs(array[i] - array[i + 1]);
            if (!(n >= 1 && n <= 3)) {
                return false;
            }
        }

        return true;
    }

    //dampner
    private static boolean isDampnerSafe(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int[] modifiedArray = removeElement(array, i);
            if (isSafe(modifiedArray)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
              return false;
            }
        }

        return true;
    }

    private static boolean isInverseSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
              return false;
            }
        }

        return true;
    }

    private static int[] removeElement(int[] array, int index) {
        int[] result = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                result[j++] = array[i];
            }
        }
        return result;
    }
}