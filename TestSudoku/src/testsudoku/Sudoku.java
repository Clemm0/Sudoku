package testsudoku;
//un po troppe librerie
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sudoku {
    //modificare appena possibile
    public static void main(String[] args) {
        List<int[][]> grids = new ArrayList<>();
        String filePath = "sudoku.txt";
        String line;
        Grid grid = new Grid();
        int row = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    if (row > 0) {
                        grids.add(grid.grid);
                        grid.grid = new int[9][9];
                        row = 0;
                    }
                } else {
                    String[] numbers = line.split(" ");
                    for (int col = 0; col < numbers.length; col++) {
                        grid.grid[row][col] = Integer.parseInt(numbers[col]);
                    }
                    row++;
                }
            }
            if (row > 0) {
                grids.add(grid.grid);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a Sudoku grid (1 to " + grids.size() + "): ");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= grids.size()) {
            grid.showGrid(grids.get(choice - 1));
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
