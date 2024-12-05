package D1;

import java.util.ArrayList;
import java.util.Scanner;

public class D1P2 {
    public static void runD1P2() {        
        Scanner scanner = new Scanner(System.in);

        int n = 2000;
        int similarityScore = 0;

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        ArrayList<Integer> firstIndexList = new ArrayList<>();
        ArrayList<Integer> secondIndexList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                firstIndexList.add(numbers[i]);
            } else {
                secondIndexList.add(numbers[i]);
            }
        }

        for (int i = 0; i < firstIndexList.size(); i++) {
            int times = 0;

            for (int j = 0; j < secondIndexList.size(); j++) {
                if (firstIndexList.get(i).equals(secondIndexList.get(j))) {
                    times++;
                }
            }
            
            similarityScore += times*firstIndexList.get(i);
        }

        System.out.println(similarityScore);
    }
}
