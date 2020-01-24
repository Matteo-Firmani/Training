package org.eclipse.che.examples;

public class GameOfLife{

    private char live = 'L';
    private char dead = 'D';

    private int rows = 5;
    private int columns = 5;

    private char[][] grid = new char[rows][columns];

    private void initializeGridWithAllDead(){
        for(int i=0;i<rows;i++){
            for(int x=0;x<columns;x++)
            {
                grid[i][x] = dead;
            }
        }
    }

    private boolean isInsideTheGrid(int row, int col){
        return row>=0 && col>=0 && row<rows && col<columns;
    }

    private void setLiveCell(int row, int col){
        grid[row][col] = live;
    }

    private void setDeadCell(int row, int col){
        grid[row][col] = dead;
    }

    private boolean checkNeighbourugn(){
        return false;
    }



}
