package core;

public interface SelectablePiece {

	Piece selectPiece(int row, int col);

	boolean[][] getPieceMoves(Board board);
}