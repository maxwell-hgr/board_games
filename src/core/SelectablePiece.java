package core;

public interface SelectablePiece {

	void selectPiece(int row, int col);

	boolean[][] getPieceMoves(Board board);
}