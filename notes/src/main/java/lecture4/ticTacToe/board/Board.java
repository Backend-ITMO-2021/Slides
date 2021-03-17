package lecture4.ticTacToe.board;


import lecture4.ticTacToe.game.Result;

public interface Board {
  Position getPosition();

  Cell getCell();

  Result makeMove(Move move);
}
