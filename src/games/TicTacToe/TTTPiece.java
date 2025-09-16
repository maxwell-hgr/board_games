package games.TicTacToe;

import core.Piece;
import core.Player;

public class TTTPiece implements Piece {

	private Player owner;

	public TTTPiece (Player owner) {
		this.owner = owner;
	}

	protected Player getOwner(){
		return owner;
	}
}