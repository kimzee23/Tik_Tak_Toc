import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testTicTacToe {


    private TicTacToeBroad TeoBroad;

    @BeforeEach
        public void setUp(){
        TeoBroad = new TicTacToeBroad();


    }
    @Test
    @DisplayName("Testing the Tic Tac Teo broad is empty works")
    public void testIfBoardIsEmpty()  {
      TicTacToeBroad ticTacToe = new TicTacToeBroad();
     for(int count=0;count<3;count++)
         for (int counter = 0; counter < 3; counter++)
             assertTrue(ticTacToe.isBroadEmpty(count, counter));
    }
    @Test
    @DisplayName("Testing for the occupied places")
    public void testPlaceThatIsOccupied()  {
        TicTacToeBroad ticTacToe = new TicTacToeBroad();
        ticTacToe.placeIsOccupied(1,1, Cell.X);
        assertFalse(ticTacToe.isBroadEmpty(1,1));
    }
    @Test
    @DisplayName("Test if player wins in a row")
    public void testIfWinInRow()  {
        TicTacToeBroad ticTacToe = new TicTacToeBroad();
        ticTacToe.placeIsOccupied(0,0, Cell.X);
        ticTacToe.placeIsOccupied(0,1, Cell.X);
        ticTacToe.placeIsOccupied(0,2, Cell.X);
        assertTrue(ticTacToe.winnerChecker(Cell.X));
    }
    @Test
    @DisplayName("Test if player wins in col")
    public void testIfWinInCol()  {
        TicTacToeBroad ticTacToe = new TicTacToeBroad();
        ticTacToe.placeIsOccupied(0,1, Cell.O);
        ticTacToe.placeIsOccupied(1,1, Cell.O);
        ticTacToe.placeIsOccupied(2,1, Cell.O);
        assertTrue(ticTacToe.winnerChecker(Cell.O));
    }
    @Test
    @DisplayName("Test if it wins diagonals")
    public void testIfWinDiagonals()  {
        TicTacToeBroad ticTacToeToe = new TicTacToeBroad();
        ticTacToeToe.placeIsOccupied(0,0, Cell.O);
        ticTacToeToe.placeIsOccupied(1,1, Cell.O);
        ticTacToeToe.placeIsOccupied(2,2, Cell.O);
        assertTrue(ticTacToeToe.winnerChecker(Cell.O));

    }
    @Test
    @DisplayName("Test for when the game is draw")
    public void testIfDraw()  {
        TicTacToeBroad ticTacToe = new TicTacToeBroad();
        Cell[][] Moves = {
                {Cell.X, Cell.O, Cell.X},
                {Cell.O, Cell.X, Cell.O},
                {Cell.O, Cell.X, Cell.O}
        };

        for (int count = 0; count<3; count++)
            for (int counter = 0; counter < 3; counter++)
                TeoBroad.placeIsOccupied(count,counter,Moves[count][counter]);
        assertTrue(TeoBroad.isFull());
        assertFalse(TeoBroad.winnerChecker(Cell.X));
        assertFalse(TeoBroad.winnerChecker(Cell.O));
    }

}
