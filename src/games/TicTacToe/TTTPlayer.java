package games.TicTacToe;

public class TTTPlayer implements Player {
	
	private String id;

	public TTTPlayer(String id){
		this.id = id;
	}

	protected String getId(){
		return id;
	}
}