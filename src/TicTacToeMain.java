import java.util.Scanner;
import java.util.Random;
public class TicTacToeMain {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        TicTacToeBroad game = new TicTacToeBroad();
        int row,col;
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("=".repeat(40));
        System.out.println("Player 1, do you want to be X or O ?");
        String playerOneChoice = input.nextLine().toUpperCase();

        while (!playerOneChoice.equals("X") && !playerOneChoice.equals("O")){
            System.out.println("Invalid player choice. Try again O or X.");
            playerOneChoice = input.nextLine().toUpperCase();

        }
        Cell playerOne = playerOneChoice.equals("X")? Cell.X : Cell.O;
        Cell playerTwo = (playerOne== Cell.X)? Cell.O : Cell.X;

        Cell currentPlayer = Cell.X;

        while(!game.isFull()){
            System.out.println("Current broad:");
            game.printBroad();
            System.out.println("Current player:"+((currentPlayer == playerOne)?"player 1":"player 2")+ "(" + currentPlayer + ")");


            System.out.println("choose a cell between cell 1 to 9");
            int cellPos = -1;
            int cellPosition = input.nextInt();

            if(cellPosition < 1 || cellPosition > 9){
                System.out.println("Invalid cell position. Try again.");
                cellPosition = rand.nextInt();
            }
            row = (cellPosition - 1) / 3;
            col = (cellPosition - 1) % 3;



            if(!game.isBroadEmpty(row,col)){
                System.out.println("Invalid position this spot has been taken");
                continue;
            }

            game.placeIsOccupied(row,col,currentPlayer);
            if(game.winnerChecker(currentPlayer)){
                System.out.println("Player wins! the final broad");
                game.printBroad();
                System.out.println("player"+(currentPlayer == playerOne ? "1":"2") + "(" + currentPlayer +")wins");
                return;
            }
            currentPlayer = (currentPlayer== Cell.X)? Cell.O : Cell.X;
        }
        System.out.println("final broad");
        game.printBroad();
        System.out.println("You guys hard a draw");
    }


}
