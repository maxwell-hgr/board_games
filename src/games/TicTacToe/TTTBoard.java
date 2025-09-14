package games.TicTacToe;

import core.Board;

public class TTTBoard implements Board {

	private Piece[][] pieces = new Piece[3][3];
	
	public Piece[][] getBoard(){
		return pieces;
	}
}