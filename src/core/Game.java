package core;

public interface Game {

	void startGame();

	void createPlayers();

	boolean[][] getAvaliableMoves();

	void move(int row, int col, boolean[][] avaliableMoves);

	boolean isEndGame();

	void changePlayer();

    Board getBoard();

    Player getPlayerMoving();
}