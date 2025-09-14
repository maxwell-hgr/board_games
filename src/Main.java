


import core.Game;
import games.TicTacToe.TTTGame;


public class Main {

	int pick;
	// game pick logic

	Game game = switch (pick) {
		case 0: yield new TTTGame();
	}

	while(!game.isEndGame()){
		if(game instanceof SelectablePiece){
			// pick piece coordinates + validate
			game.selectPiece(row, col);
		}

		// deal with terminal interface
		game.getAvaliableMoves();


		// pick move coordinates + validate and move
		game.move(row, col);

		// check if end game
		// change player

		// repeat
	}
}
