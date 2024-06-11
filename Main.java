/**
Project: Connect Four Game
Collaborators: 
* Actual Contributors
* Arsh Bhamla
* Shiv Patel
*/

/*
Game Play Basics:
* Yellow goes first, then red, alternating until one player reaches four pieces in a row
* Pieces can be vertical, horizontal, or diagonal
* Columns are numbered 1-7
*/
//checkForWin
import java.util.*; //imports all the util functions

public class Main{
  
  public static void main(String[] args){
    System.out.println("Would you like an explanation of the game?");
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    if(input.equals("yes") || input.equals("Yes")){
      System.out.println("Connect Four is a 2 player game where the objective is to get four coins in a row. You can connect them in any manner, but you have to prevent your opponent from doing the same.\nPlayers alternate, starting with yellow, and continuing until either a player wins or the board is filled.\n\n\n");
    }
    System.out.println("Welcome to Connect Four!\n\nIf you would like to choose rows and columns for your game, type \"specific\" or type \"default\" for original measurements!");
    
    int row = 0;
    int col = 0; 
    input = scan.nextLine();
    if(input.equals("specific")){
      System.out.println("How many rows would you like?");
      row = Integer.parseInt(scan.nextLine());
      while(row<4){
        System.out.println("Your value is too small. Try again: ");
        row = Integer.parseInt(scan.nextLine());
      }
      System.out.println("How many columns would you like?");
      col = Integer.parseInt(scan.nextLine());
      while (col<4){
        System.out.println("Your value is too small. Try again: ");
        col = Integer.parseInt(scan.nextLine());
      }
      
    }
    else if(input.equals("default")){
      row = 6;
      col = 7;
    }
    else{
      System.out.println("Please try again");
    }
    
    Connect4 gamePlay = new Connect4(row, col);

    System.out.println("Player one turn: ");
    
    boolean gameWon = false;
    int turn = 1; //1 = player 1, 2 = player 2

    while (!gameWon) {
      System.out.println("Current Board:\n");
      int[][] board = gamePlay.getGameBoard();
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
              System.out.print(board[i][j] + " ");
          }
          System.out.println();
      }
  
      System.out.println("\nPlayer " + turn + "'s turn. Enter the column to drop your coin:");

      boolean colPossible = false;
      while(!colPossible){
        int chosenColumn = scan.nextInt()-1;

        if (gamePlay.canPlay(chosenColumn)) {
          colPossible = true;
          int tempRow = gamePlay.putCoin(chosenColumn, turn);
          int winner = gamePlay.checkForWin(tempRow, chosenColumn);
          if(winner==0){
            if(turn == 1){
              turn = 2;
            }
            else{
              turn = 1;
            }
          }
          else{
            gameWon = true;
            //Final board Print
            System.out.println("Final Board:\n");
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
          }
        }
        else {
            System.out.println("Column is full, try again.");
        }
      }
      
    }

    
    System.out.println("Player " + turn + " wins!");
    scan.close();
  }

  
  
}
