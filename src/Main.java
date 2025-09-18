
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

            GUI gui = game.getGUI();

            System.out.println("Time for player: " + game.getPlayerMoving().getId());

            if(game instanceof SelectablePiece selectablePiece){
                gui.printBoard(game.getBoard());
                System.out.println("Select a piece:");

                int row = sc.nextInt();
                int col = sc.nextInt();
                selectablePiece.selectPiece(row, col);
            }


            boolean[][] avaliableMoves = game.getAvaliableMoves();

            gui.printBoardAvaliableMoves(game.getBoard(), avaliableMoves);

            System.out.println("Make your move: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            game.move(row, col, avaliableMoves);

            if(game.isEndGame()) {
                System.out.println("End game! Player " + game.getPlayerMoving().getId() + " won!");

                gui.printBoard(game.getBoard());
                endGame = true;
            }

            game.changePlayer();
        }
    }
}
