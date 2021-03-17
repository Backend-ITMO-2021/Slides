package lecture4.ticTacToe.player;


import lecture4.ticTacToe.board.Move;
import lecture4.ticTacToe.board.Cell;
import lecture4.ticTacToe.board.Position;

public class SequentialPlayer implements Player {
  @Override
  public Move move(final Position position, final Cell cell) {
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        final Move move = new Move(r, c, cell);
        if (position.isValid(move)) {
          return move;
        }
      }
    }
    throw new IllegalStateException("No valid moves");
  }
}
