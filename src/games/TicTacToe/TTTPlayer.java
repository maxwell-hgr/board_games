package games.TicTacToe;

import core.Player;

public class TTTPlayer implements Player {
	
	private String id;

	public TTTPlayer(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}