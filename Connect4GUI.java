/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Connect4GUI extends JFrame {

    private JButton[][] buttons;
    private Connect4 game;

    public Connect4GUI(int rows, int columns) {
        super("Connect Four");

        game = new Connect4(rows, columns);
        buttons = new JButton[rows][columns];

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(rows, columns));

        initializeButtons();
        updateUI();

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private void initializeButtons() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(buttons[i][j]);
            }
        }
    }

    private void updateUI() {
        int[][] board = game.getGameBoard();
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                if (board[i][j] == 1) {
                    buttons[i][j].setBackground(Color.YELLOW);
                } else if (board[i][j] == 2) {
                    buttons[i][j].setBackground(Color.RED);
                } else {
                    buttons[i][j].setBackground(UIManager.getColor("Button.background"));
                }
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle button click event
            if (game.canPlay(col)) {
                int tempRow = game.putCoin(col, 1); // Assuming player 1 is always human player
                int winner = game.checkForWin(tempRow, col);
                if (winner == 0) {
                    // Switch turn or perform any other game logic
                } else {
                    JOptionPane.showMessageDialog(null, "Player " + winner + " wins!");
                    System.exit(0);
                }

                updateUI(); // Update the UI after each move
            } else {
                JOptionPane.showMessageDialog(null, "Column is full, try again.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Connect4GUI(6, 7));
    }
}*/
