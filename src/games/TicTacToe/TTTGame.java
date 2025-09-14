package games.TicTacToe;

import core.Game;
import games.TicTacToe.TTTBoard;

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

	public void move(int row, int col){

	};

	public boolean isEndGame(Player player, Board board){
		// game win logic

		return true;
	};

	private void createPlayers(){
		Player p1 = new TTTPlayer("X");
		Player p2 = new TTTPlayer("O");

		this.players.add(p1);
		this.players.add(p2);

		this.playerMoving = p1;
	}
}