package D4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class D4 {
    public static void runD4() {
        
        String filePath = "/Users/martinsanin/GitHub/AOC2024/src/inputs/D4input.txt";

        ArrayList<String> input = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        String[] grid = input.toArray(new String[0]);

        //String target = "XMAS";
        String target = "MAS";
        int count = countOccurrences(grid, target);

        System.out.println(count);
    }

    public static int countOccurrences(String[] grid, String target) {
        int rows = grid.length;
        int cols = grid[0].length();
        int count = 0;

        int[][] directions = {
            //{0, 1},   // Horizontal right
            //{0, -1},  // Horizontal left
            //{1, 0},   // Vertical down
            //{-1, 0},  // Vertical up
            {1, 1},   // Diagonal down-right
            {1, -1},  // Diagonal down-left
            {-1, 1},  // Diagonal up-right
            {-1, -1}  // Diagonal up-left
        };

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                    //setup direction, setup or statement to check if backwards works too, inner statement to check the otehr side or inverse
                    if (matches(grid, r, c, target, direction)) {
                        count++;
                    }
            }
        }

        return count;
    }

    private static boolean matches(String[] grid, int row, int col, String target, int[] direction) {
        int rows = grid.length;
        int cols = grid[0].length();
        int targetLength = target.length();

        for (int i = 0; i < targetLength; i++) {
            int newRow = row + i * direction[0];
            int newCol = col + i * direction[1];

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                return false;
            }

            if (grid[newRow].charAt(newCol) != target.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}