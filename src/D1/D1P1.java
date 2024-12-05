package D1;
import java.util.ArrayList;
import java.util.Scanner;

public class D1P1 {
    public static void runBigNumbers(){
        Scanner scanner = new Scanner(System.in);

        int n = 2000;
        int difference = 0;

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        ArrayList<Integer> oddIndexList = new ArrayList<>();
        ArrayList<Integer> evenIndexList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                evenIndexList.add(numbers[i]);
            } else {
                oddIndexList.add(numbers[i]);
            }
        }

        int[] evenIndexArray = evenIndexList.stream().mapToInt(Integer::intValue).toArray();
        int[] oddIndexArray = oddIndexList.stream().mapToInt(Integer::intValue).toArray();

        quickSort(oddIndexArray);
        quickSort(evenIndexArray);

        for (int i = 0; i < oddIndexArray.length; i++) {
            difference += Math.abs(oddIndexArray[i] - evenIndexArray[i]);
        }

        System.out.println(difference);
    }

    //Quick sort
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
