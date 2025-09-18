package games.TicTacToe;

import core.Board;
import core.Game;
import core.Piece;
import core.Player;

public class TTTGame implements Game {

	private TTTBoard board;
	private TTTPlayer[] players = new TTTPlayer[2];
	private TTTPlayer playerMoving;
	private TTTGUI gui;

	public TTTGame () {
		this.startGame();
		this.createPlayers();
	}

	public void startGame(){
		this.board = new TTTBoard();
		this.gui = new GUI();
	}

	public boolean[][] getAvaliableMoves(){
		boolean[][] avaliableMoves = new boolean[3][3];

		TTTPiece[][] pieces = this.board.getPieces();
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
			pieces[row][col] = new TTTPiece(playerMoving, playerMoving.getId());
		}
	};

	public boolean isEndGame(){
		TTTPiece[][] pieces = this.board.getPieces();

        TTTPiece p1 = pieces[0][0];
        TTTPiece p2 = pieces[0][1];
        TTTPiece p3 = pieces[0][2];
        TTTPiece p4 = pieces[1][0];
        TTTPiece p5 = pieces[1][1];
        TTTPiece p6 = pieces[1][2];
        TTTPiece p7 = pieces[2][0];
        TTTPiece p8 = pieces[2][1];
        TTTPiece p9 = pieces[2][2];

        if(p1 != null && p2 != null && p3 != null
            && p1.getOwner() ==  p2.getOwner() && p2.getOwner() ==  p3.getOwner()) return true;

        if(p4 != null && p5 != null && p6 != null
                && p4.getOwner() == p5.getOwner() && p5.getOwner() == p6.getOwner()) return true;

        if(p7 != null && p8 != null && p9 != null
            && p7.getOwner() == p8.getOwner() && p8.getOwner() == p9.getOwner()) return true;

        if(p1 != null && p4 != null && p7 != null
                && p1.getOwner() == p4.getOwner() && p4.getOwner() == p7.getOwner()) return true;

        if(p2 != null && p5 != null && p8 != null
                && p2.getOwner() == p5.getOwner() && p5.getOwner() == p8.getOwner()) return true;

        if(p3 != null && p6 != null && p9 != null
                && p3.getOwner() == p6.getOwner() && p6.getOwner() == p9.getOwner()) return true;

        if(p1 != null && p5 != null && p9 != null
            && p1.getOwner() ==  p5.getOwner()  && p5.getOwner() ==  p9.getOwner())  return true;

        if(p3 != null && p5 != null && p7 != null
            && p3.getOwner() == p5.getOwner() && p5.getOwner() == p7.getOwner()) return true;

		return false;
	};

	public void changePlayer () {
		if(playerMoving == players[0]) playerMoving = players[1];
		else playerMoving = players[0];
	}

	public void createPlayers(){
		TTTPlayer p1 = new TTTPlayer("X");
		TTTPlayer p2 = new TTTPlayer("O");

		this.players[0] = p1;
		this.players[1] = p2;

		this.playerMoving = p1;
	}

    public Board getBoard() {
        return board;
    }

    public Player getPlayerMoving() {
        return playerMoving;
    }

    public GUI getGUI(){
    	return this.gui;
    }
}