

public class TTTGUI implements GUI {
	
	public void printBoardAvaliableMoves(TTTBoard board, boolean[][] avaliableMoves){
		Piece[][] pieces = board.getPieces();
        for(int i = 0; i < board.getPieces().length; i++){
            Piece[] vector = pieces[i];
            generateLine(vector);
            System.out.print("| ");
            for(int j = 0; j < vector.length; j++){
                Piece piece = pieces[i][j];

                if(avaliableMoves[i][j]){
                    if(piece != null) System.out.print(ANSI_BLUE_BACKGROUND + piece.getId() + ANSI_RESET);
                    else System.out.print(ANSI_BLUE_BACKGROUND + " " + ANSI_RESET);
                } else {
                    if(piece != null) System.out.print(piece.getId());
                    else System.out.print(" ");
                }

                if(j < vector.length-1) System.out.print(" | ");
            }
            System.out.print(" |");
            System.out.println();
	};

	public void printBoard(TTTBoard board){
		    for(Piece[] pieces : board.getPieces()){
	            generateLine(pieces);
	            System.out.print("| ");
	            for(int i = 0; i < pieces.length; i++){
	                Piece piece = pieces[i];
	                if(piece != null) System.out.print(piece.getId());
	                else System.out.print(" ");
	                if(i < pieces.length-1) System.out.print(" | ");
            }
            System.out.print(" |");
            System.out.println();
        }
	};


	private void generateLine(Piece[] pieces){
        String line = "";
        for(int i = 0; i < pieces.length; i++){
            line += "----";
        }
        line += "-";
        System.out.println(line);
    }
}