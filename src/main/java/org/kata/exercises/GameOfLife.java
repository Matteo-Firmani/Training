package org.eclipse.che.examples;

public class GameOfLife{

    private static char live = 'L';
    private static char dead = 'D';

    private static int rows = 5;
    private static int columns = 5;

    private static char[][] grid = new char[rows][columns];

    public static void main(String[] args){
        initializeGridWithAllDead();
        for(int i=0;i<20;i++){
            System.out.println("--------------------------------------------------------");                
            printGrid();
            for(int z=0;z<rows;z++){
                for(int a=0;a<columns;a++)
                {
                    checkCell(z, a);
                }
            }
            System.out.println("--------------------------------------------------------");
            printGrid();
            System.out.println("--------------------------------------------------------");
        }
    }

    private static void initializeGridWithAllDead(){
        for(int i=0;i<rows;i++){
            for(int x=0;x<columns;x++)
            {
                if((i==0 && x==2) || (i==1 && x==2) || (i==1 && x==1))
                {
                    grid[i][x] = live;
                }
                else{
                    grid[i][x] = dead;
                }
            }
        }
    }

    private static boolean isInsideTheGrid(int row, int col){
        return row>=0 && col>=0 && row<rows && col<columns;
    }

    private static boolean isLiveCell(int row, int col){
        return grid[row][col]==live;
    }

    public static  boolean isDead(int row, int column) {
        return grid[row][column] == dead;
    }


    public static void printGrid(){
        StringBuilder sb;
        for(int x=0;x<columns;x++){
            sb = new StringBuilder();
            for(int i=0;i<rows;i++){
                sb.append("|").append(grid[i][x]).append("|");
            }
             sb.append("\n");
            System.out.print(sb.toString());
        }
    }

    private static int countLiveNeighbours(int row, int column){
        int[][] cellsToCheck = {
                {row - 1, column - 1},
                {row - 1, column},
                {row - 1, column + 1},
                {row, column + 1},
                {row + 1, column + 1},
                {row + 1, column},
                {row + 1, column - 1},
                {row, column - 1},
        };

        int livingNeighbours = 0;

        for (int i = 0; i < cellsToCheck.length; i++) {

            int rowToCheck = cellsToCheck[i][0];
            int colTocheck = cellsToCheck[i][1];

            if (isInsideTheGrid(rowToCheck, colTocheck) && isLiveCell(rowToCheck, colTocheck)) {
                livingNeighbours ++ ;
            }

        }

        return livingNeighbours;
    }

    private static void checkCell(int row, int col){
        char[][] nextGenerationGrid = new char[rows][columns];

        for (int y = 0; y < rows; y++) {

            for (int x = 0; x < columns; x++) {

                if (thisCellIsAliveAndHasLessThanTwoLivingNeighbours(y, x)) {
                    nextGenerationGrid[y][x] = dead;
                } else if (thisCellIsAliveAndHasTwoOrThreeLivingNeighbours(y, x)) {
                    nextGenerationGrid[y][x] = live;
                } else if (thisCellIsAliveAndHasMoreThanThreeLivingNeighbours(y, x)) {
                    nextGenerationGrid[y][x] = dead;
                } else if (thisCellIsDeadAndHasThreeLivingNeighbours(y, x)) {
                    nextGenerationGrid[y][x] = live;
                } else {
                    nextGenerationGrid[y][x] = grid[y][x];
                }
            }

        }

        grid = nextGenerationGrid.clone();

    }

    private static  boolean thisCellIsDeadAndHasThreeLivingNeighbours(int row, int column) {
        int livingNeighbours = countLiveNeighbours(row, column);
        return isDead(row, column) && livingNeighbours == 3;
    }

    private static  boolean thisCellIsAliveAndHasMoreThanThreeLivingNeighbours(int row, int column) {
        int livingNeighbours = countLiveNeighbours(row, column);
        return isLiveCell(row, column) && livingNeighbours > 3;
    }

    private static  boolean thisCellIsAliveAndHasTwoOrThreeLivingNeighbours(int row, int column) {
        int livingNeighbours = countLiveNeighbours(row, column);
        return isLiveCell(row, column) && (livingNeighbours == 2 || livingNeighbours == 3);
    }

    private static  boolean thisCellIsAliveAndHasLessThanTwoLivingNeighbours(int row, int column) {
        int neighboursCount = countLiveNeighbours(row, column);
        return isLiveCell(row, column) && neighboursCount < 2;
    }


}
