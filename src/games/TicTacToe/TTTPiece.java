package games.TicTacToe;

import core.Piece;
import core.Player;

public class TTTPiece implements Piece {

	private Player owner;

	protected Player getOwner(){
		return owner;
	}
}