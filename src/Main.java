
import core.Board;
import core.Game;
import core.Piece;
import core.SelectablePiece;
import games.TicTacToe.TTTGame;

import java.util.Scanner;


public class Main {

    public final static String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public final static String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int pick;
        System.out.println("Wich game do you want to play?");

        pick = sc.nextInt();

        Game game = switch (pick) {
            case 0: yield new TTTGame();
            default: {
                System.out.println("Invalid input");
                yield null;
            }
        };

        boolean endGame = false;
        while(game != null && !endGame){

            System.out.println("Time for player: " + game.getPlayerMoving().getId());

            if(game instanceof SelectablePiece selectablePiece){
                printBoard(game.getBoard());
                System.out.println("Select a piece:");

                int row = sc.nextInt();
                int col = sc.nextInt();
                selectablePiece.selectPiece(row, col);
            }


            boolean[][] avaliableMoves = game.getAvaliableMoves();
            printBoardAvaliableMoves(game.getBoard(), avaliableMoves);

            System.out.println("Make your move: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            game.move(row, col, avaliableMoves);

            if(game.isEndGame()) {
                System.out.println("End game! Player " + game.getPlayerMoving().getId() + " won!");
                printBoard(game.getBoard());
                endGame = true;
            }

            game.changePlayer();
        }
    }

    public static void printBoard(Board board){
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
    }

    public static void printBoardAvaliableMoves(Board board, boolean[][] avaliableMoves){

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
        }
    }

    public static void generateLine(Piece[] pieces){
        String line = "";
        for(int i = 0; i < pieces.length; i++){
            line += "----";
        }
        line += "-";
        System.out.println(line);
    }

}
