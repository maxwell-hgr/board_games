


import core.Game;
import games.TicTacToe.TTTGame;


public class Main {

	int pick;
	// game pick logic

	Game game = switch (pick) {
		case 0: yield new TTTGame();
	}

	boolean endGame = false;
	while(endGame){
		if(game instanceof SelectablePiece){
			// pick piece coordinates + validate
			game.selectPiece(row, col);
		}

		// deal with terminal interface
		boolean[][] avaliableMoves = game.getAvaliableMoves();

		game.move(row, col, avaliableMoves);

		endGame = game.isEndGame();

		game.changePlayer();
	}
}
