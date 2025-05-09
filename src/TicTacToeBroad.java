
public class TicTacToeBroad {
    private final Cell[][] ToeBroad;

    public TicTacToeBroad() {
        ToeBroad = new Cell[3][3];
        for (int count=0;count<3;count++)
            for(int counter=0;counter<3;counter++)
                ToeBroad[count][counter] = Cell.EMPTY;

    }


    public boolean isBroadEmpty(int row, int col) {
        return ToeBroad[row][col] == Cell.EMPTY;
    }

    public void placeIsOccupied(int row, int col, Cell players) {
        ToeBroad[row][col] = players;
    }

    public boolean winnerChecker(Cell players) {
        for (int count=0;count<3;count++){
            if ((ToeBroad[count][0] == players && ToeBroad [count][1] == players && ToeBroad [count][2] == players) ||
             (ToeBroad [0][count] == players && ToeBroad [1][count] == players && ToeBroad [2][count] == players)){
                return true;
            }
        }
        return ((ToeBroad [0][0] == players && ToeBroad[1][1]== players && ToeBroad[2][2]== players) ||
                (ToeBroad [0][2] == players && ToeBroad [1][1]== players && ToeBroad[2][0]== players));

    }

    public boolean isFull() {
        for (int count=0;count<3;count++)
            for (int counter=0;counter<3;counter++)
                if (ToeBroad[count][counter] == Cell.EMPTY)
                    return false;
        return true;
    }
    public void printBroad() {
        System.out.println("-".repeat(13));
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                String value = ToeBroad[row][col] == Cell.EMPTY ? " " : ToeBroad[row][col].toString();
                System.out.print(value + " | ");
            }
            System.out.println();
            System.out.println("-".repeat(13));
        }
    }


    public Cell getCell(int count, int counter) {
        return ToeBroad[count][counter];
    }
}