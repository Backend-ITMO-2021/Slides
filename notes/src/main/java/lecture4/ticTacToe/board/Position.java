package lecture4.ticTacToe.board;


public interface Position {
  boolean isValid(Move move);

  Cell getCell(int r, int c);
}
