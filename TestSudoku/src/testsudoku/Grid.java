package testsudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Grid {

    int[][] grid;
    private int[] ck = new int[9];

    public Grid() {
        grid = new int[9][9];
    }

    public void loadGridsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int gridCount = 0;
            int lineCount = 0;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] numbers = line.trim().split("\\s+");
                for (int i = 0; i < 9; i++) {
                    grid[lineCount][i] = Integer.parseInt(numbers[i]);
                }
                lineCount++;

                if (lineCount == 9) {
                    gridCount++;
                    lineCount = 0;
                }
            }
            System.out.println("Loaded " + gridCount + " Sudoku grids.");
        } catch (IOException e) {
            System.err.println("Error reading the grid file: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error parsing the grid values: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void showGrid(int[][] grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void showGrid() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(this.grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    //controlli
    public boolean checkLineForDuplicates(int l) {
        System.arraycopy(grid[l], 0, ck, 0, 9);
        return checkForDuplicates(ck);
    }

    public static boolean checkForDuplicates(int[] array) {
        Set<Integer> seenNumbers = new HashSet<>();

        for (int number : array) {
            if (number < 1 || number > 9) {
            }
            if (!seenNumbers.add(number)) {
                return true;
            }
        }
        return false;
    }
}
