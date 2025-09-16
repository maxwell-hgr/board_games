package games.TicTacToe;

import core.Piece;
import core.Player;

public class TTTPiece implements Piece {

    private String id;

	private Player owner;

	public TTTPiece (Player owner, String id) {
		this.owner = owner;
        this.id = id;
	}

	public Player getOwner(){
		return owner;
	}

    public String getId(){ return id; }
}