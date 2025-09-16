package games.TicTacToe;

import core.Game;
import games.TicTacToe.TTTBoard;
import games.TicTacToe.TTTPiece;

public class TTTGame implements Game {

	private Board board;
	private Player[] players = new TTTPlayer[2];
	private Player playerMoving;

	public TTTGame () {
		this.startGame();
		this.createPlayers();
	}

	public void startGame(){
		this.board = new TTTBoard();
	}

	public boolean[][] getAvaliableMoves(){
		boolean[][] avaliableMoves = new boolean[3][3];

		Piece[][] pieces = this.board.getPieces();
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(pieces[i][j] == null){
					avaliableMoves[i][j] = true;
				}
			}
		}

		return avaliableMoves;
	}

	public void move(int row, int col, boolean[][] avaliableMoves){
		Piece[][] pieces = board.getPieces();

		if(avaliableMoves[row][col] == true){
			pieces[row][col] = new Piece(playerMoving);
		}
	};

	public boolean isEndGame(Player player, Board board){
		Piece[][] pieces = board.getPieces();

		if(pieces[0,0].getOwner() == playerMoving && 
			pieces[0,1].getOwner() == playerMoving && 
			pieces[0,2].getOwner() == playerMoving) return true;

		if(pieces[0,0].getOwner() == playerMoving && 
			pieces[1,0].getOwner() == playerMoving && 
			pieces[2,0].getOwner() == playerMoving) return true;

		if(pieces[0,0].getOwner() == playerMoving && 
			pieces[1,1].getOwner() == playerMoving && 
			pieces[2,2].getOwner() == playerMoving) return true;

		if(pieces[0,1].getOwner() == playerMoving && 
			pieces[1,1].getOwner() == playerMoving && 
			pieces[2,1].getOwner() == playerMoving) return true;

		if(pieces[0,2].getOwner() == playerMoving && 
			pieces[1,1].getOwner() == playerMoving && 
			pieces[2,0].getOwner() == playerMoving) return true;

		if(pieces[1,0].getOwner() == playerMoving && 
			pieces[1,1].getOwner() == playerMoving && 
			pieces[1,2].getOwner() == playerMoving) return true;

		return false;
	};

	public void changePlayer () {
		if(playerMoving == players[0]) playerMoving = players[1];
		else playerMoving = players[0];
	}

	private void createPlayers(){
		Player p1 = new TTTPlayer("X");
		Player p2 = new TTTPlayer("O");

		this.players.add(p1);
		this.players.add(p2);

		this.playerMoving = p1;
	}
}