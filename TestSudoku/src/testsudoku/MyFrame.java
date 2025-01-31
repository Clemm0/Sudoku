//decomentare per il frame e rimettere nel main
//MyFrame fr=new MyFrame();
package testsudoku;
//https://pages.di.unipi.it/milazzo/teaching/AA1314-ProgJava/extra/DispensaSwing.pdf//
//https://www.site24x7.com/it/tools/json-a-java.html//
import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.ArrayList;

public class MyFrame extends JFrame {

    int[][] grid = new int[9][9];

    public MyFrame() {
        super("Esempio");

        // Inizializzazione della griglia con numeri randomici
        fillGridWithRandomNumbers();

        // Pannelli
        JPanel nordPnl = new JPanel();
        JPanel centroPnl = new JPanel();
        JPanel sudPnl = new JPanel();

        // Componenti
        JLabel infoLbl = new JLabel("SUDOKU");
        JCheckBox opz1Chk = new JCheckBox("Opz1");
        JCheckBox opz2Chk = new JCheckBox("Opz2");
        JButton okBtn = new JButton("OK");
        JButton cancBtn = new JButton("Annulla");

        // Layout della griglia Sudoku
        centroPnl.setLayout(new GridLayout(9, 9, 1, 1)); // Griglia 9x9 con margini

        // Creazione della griglia con JLabel
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JLabel cell = new JLabel(String.valueOf(grid[i][j]), SwingConstants.CENTER);
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cell.setOpaque(true);
                cell.setBackground(Color.WHITE);
                centroPnl.add(cell);
            }
        }

        // Layout e componenti
        nordPnl.add(infoLbl);

        sudPnl.add(opz1Chk);
        sudPnl.add(opz2Chk);
        sudPnl.add(okBtn);
        sudPnl.add(cancBtn);

        // Aggiunta dei pannelli al frame
        getContentPane().add(nordPnl, BorderLayout.NORTH);
        getContentPane().add(centroPnl, BorderLayout.CENTER);
        getContentPane().add(sudPnl, BorderLayout.SOUTH);

        // Impostazioni del frame
        pack();
        setSize(600, 600); // Dimensione standard per visualizzare la griglia
        setLocationRelativeTo(null); // Centra la finestra
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Permette di chiudere il programma
        setVisible(true);
    }

    // Metodo per riempire la griglia con numeri randomici nei blocchi 3x3
    private void fillGridWithRandomNumbers() {
        for (int blockRow = 0; blockRow < 3; blockRow++) {
            for (int blockCol = 0; blockCol < 3; blockCol++) {
                fillBlock(blockRow, blockCol);
            }
        }
    }

    // Riempie un singolo blocco 3x3 con numeri casuali da 1 a 9
    private void fillBlock(int blockRow, int blockCol) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers); // Mischia i numeri

        int startRow = blockRow * 3;
        int startCol = blockCol * 3;
        int index = 0;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                grid[i][j] = numbers.get(index++);
            }
        }
    }

    // Metodo main per eseguire l'applicazione
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyFrame::new);
    }
}
