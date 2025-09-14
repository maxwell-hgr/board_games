package core;

public interface Game {

	Board startGame();

	boolean move(Player player, Board board, int row, int col);
}