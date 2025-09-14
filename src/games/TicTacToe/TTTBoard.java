package games.TicTacToe;

import core.Board;

public class TTTBoard implements Board {

	private Piece[][] pieces;

	public TTTBoard () {
		this.pieces = new Piece[3][3];
	}

	protected Piece[][] getPieces(){
		return pieces;
	}
}