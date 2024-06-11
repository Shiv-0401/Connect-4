public class Connect4 {
  int[][] gameBoard;
  // int turn; //1 = player 1, 2 = player 2
  
  public Connect4(int rows, int columns) {
      gameBoard = newBoard(rows, columns);
  }
  
  public int[][] newBoard(int r, int c) {
      // This method makes a new board to start a game
      int[][] board = new int[r][c];
      for (int i = 0; i < r; i++) {
          for (int j = 0; j < c; j++) {
              board[i][j] = 0;
          }
      }
      return board;
  }
  
  public boolean canPlay(int col) {
      // This method checks if the player is allowed to make a move in the row they
      // selected
      if (col < 0 || col >= gameBoard[0].length) {
          return false; // Should throw an error if they try to go outside of the domain
      }
      return gameBoard[0][col] == 0; // If the top row is full, it will throw false and not allow the person to play the coin
  }

  public int putCoin(int col, int turn) {
      for (int i = gameBoard.length - 1; i >= 0; i--) {
          if (gameBoard[i][col] == 0) {
              gameBoard[i][col] = turn;
              return i;
          }
      }
      return -1;
  }

  public int[][] getGameBoard() {
      // This method returns the gameBoard
      return gameBoard;
  }
  
  public int checkForWin(int r, int c) {
    // This method determines if a win has been achieved
    int value = gameBoard[r][c]; // 1 or 2
    int counter = 0;
    // Check for wins in rows
    for (int i = 0; i < gameBoard.length; i++) {
      for (int j = 0; j < gameBoard[0].length; j++) {
        if (gameBoard[i][j] == value) {
          counter++;
          if (counter == 4) {
            return value; // Means a player wins
          }
        }
        else {
        counter = 0;
        }
      }
    }

    // Check for wins in columns
    for (int i = 0; i < gameBoard[0].length; i++) {
      for (int j = 0; j < gameBoard.length; j++) {
          if (gameBoard[j][i] == value) {
              counter++;
              if (counter == 4) {
                  return value; // Means a player wins
              }
          } else {
              counter = 0;
          }
      }
    }

      // Check for wins in diagonals

      // Up Right
      if (c < gameBoard[0].length - 3 && r >= 3) {
          int a = r;
          int b = c;
          for (int i = 0; i < 4; i++) {
            if(a<gameBoard.length && b<gameBoard[0].length &&a>=0&&b>=0){
              if (gameBoard[a][b] == value) {
                  counter++;
              } else {
                  counter = 0;
              }
            }
            if (counter == 4) {
              return value;
            }
            a++;
            b--;
          }
      }

      // Up Left
      if (c >= 3 && r >= 3) {
          int a = r;
          int b = c;
          for (int i = c; i < c-4; i--) {
            if(a<gameBoard.length && b<gameBoard[0].length &&a>=0&&b>=0){
              if (gameBoard[a][b] == value) {
                  counter++;
              } else {
                  counter = 0;
              }
            }
            if (counter == 4) {
                return value;
            }
            a--;
            b--;
          }

      }

      // Down Right
      if (c < gameBoard[0].length - 3 && r < gameBoard.length - 3) {
          int a = c;
          int b = r;
          for (int i = c; i < c+4; i++) {
            if(a<gameBoard.length && b<gameBoard[0].length &&a>=0&&b>=0){
              if (gameBoard[a][b] == value) {
                  counter++;
              } else {
                  counter = 0;
              }
            }
            if (counter == 4) {
              return value;
            }
            a++;
            b++;
          }
      }

      // Down Left
      if (c >= 3 && r < gameBoard.length - 3) {
          int a = c;
          int b = r;
          for (int i = c; i < c-4; i--) {
            if(a<gameBoard.length && b<gameBoard[0].length &&a>=0&&b>=0){
              if (gameBoard[a][b] == value) {
                  counter++;
              } else {
                  counter = 0;
              }
            }
            if (counter == 4) {
                return value;
            }
            a++;
            b--;
          }
        }
        return 0;
    }
}