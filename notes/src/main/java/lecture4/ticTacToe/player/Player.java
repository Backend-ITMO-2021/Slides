package lecture4.ticTacToe.player;


import lecture4.ticTacToe.board.Move;
import lecture4.ticTacToe.board.Cell;
import lecture4.ticTacToe.board.Position;

public interface Player {
  Move move(Position position, Cell cell);
}
