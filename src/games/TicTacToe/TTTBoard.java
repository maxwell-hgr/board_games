package games.TicTacToe;

import core.Board;

public class TTTBoard implements Board {

	private TTTPiece[][] pieces;

	public TTTBoard () {
		this.pieces = new TTTPiece[3][3];
	}

	public TTTPiece[][] getPieces(){
		return pieces;
	}
}