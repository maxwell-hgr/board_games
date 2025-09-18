package core;

public interface Game {

	void startGame();

	void createPlayers();

	boolean[][] getAvaliableMoves();

	void move(int row, int col, boolean[][] avaliableMoves);

	boolean isEndGame();

	void changePlayer();

	GUI getGUI();

    Board getBoard();

    Player getPlayerMoving();
}