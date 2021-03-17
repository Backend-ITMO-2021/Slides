package lecture4.ticTacToe;


import lecture4.ticTacToe.board.TicTacToeBoard;
import lecture4.ticTacToe.game.Game;
import lecture4.ticTacToe.player.HumanPlayer;

public class Main {
  public static void main(String[] args) {
    final Game game = new Game(false, new HumanPlayer(), new HumanPlayer());
    int result;
    do {
      result = game.play(new TicTacToeBoard());
      System.out.println("Game result: " + result);
    } while (result != 0);
  }
}
