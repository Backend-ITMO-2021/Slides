package lecture4.ticTacToe.player;

import lecture4.ticTacToe.board.Move;
import lecture4.ticTacToe.board.Cell;
import lecture4.ticTacToe.board.Position;

import java.util.Random;


public class RandomPlayer implements Player {
  private final Random random;

  public RandomPlayer(final Random random) {
    this.random = random;
  }

  public RandomPlayer() {
    this(new Random());
  }

  @Override
  public Move move(final Position position, final Cell cell) {
    while (true) {
      int r = random.nextInt(3);
      int c = random.nextInt(3);
      final Move move = new Move(r, c, cell);
      if (position.isValid(move)) {
        return move;
      }
    }
  }
}
