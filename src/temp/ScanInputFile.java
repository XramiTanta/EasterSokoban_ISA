package temp;

import Exceptions.BoardConstructorException;
import Structure.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ScanInputFile {
    private char[][] grid;
    public String file_path;

    public ScanInputFile(String file_path) throws IOException {
        this.file_path = file_path;
        this.grid = this.scanInput();
    }


    private char[][] scanInput() throws IOException {
        try (FileReader fileReader = new FileReader(this.file_path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int rows = 0;
            int columns = 0;

            // Determine the dimensions of the array (board) input
            while ((line = bufferedReader.readLine()) != null) {
                columns = line.length();
                rows++;
            }

            // Create the 2D array for store the input in array then i process it
            // for construct the board's grid
            char[][] array2D = new char[rows][columns];

            // Reset the reader back to the beginning of the file
            fileReader.close();
            bufferedReader.close();

            // Recreate the FileReader and BufferedReader objects
            FileReader newFileReader = new FileReader(this.file_path);
            BufferedReader newBufferedReader = new BufferedReader(newFileReader);

            // Transfer the values to the 2D array
            int row = 0;
            while ((line = newBufferedReader.readLine()) != null) {
                for (int col = 0; col < line.length(); col++) {
                    array2D[row][col] = line.charAt(col);
                }
                row++;
            }
            return array2D;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Board charToBoard(char[][] input) throws BoardConstructorException {
//      declare the properties of board class
        int size = input.length;
        Cell[][] grid = new Cell[size][size];
        List<Egg> eggs = new ArrayList<Egg>();
        List<Cell> goal_cells = new ArrayList<Cell>();
        Bunny bunny = null;
        try {
            int i = 0, j = 0;
            for (i = 0; i < size; i++) {
                for (j = 0; j < size; j++) {

                    //construct the board for every char and what is the cell type with all elements
                    //on the board

                    switch (input[i][j]) {
                        case '#':
                            grid[i][j] = new Cell(new Position(i, j), CellType.STONE, false, -1, Color.WHITE);
                            break;
                        case '.':
                            grid[i][j] = new Cell(new Position(i, j), CellType.GROUND, false, -1, Color.Black);
                            break;
                        case '_':
                            grid[i][j] = new Cell(new Position(i, j), CellType.GOAL_CELL, false, -1, Color.YELLOW);
                            goal_cells.add(grid[i][j]);
                            break;
                        case '@':
                            eggs.add(new Egg(new Position(i, j), Color.RED));
                            grid[i][j] = new Cell(new Position(i, j), CellType.GROUND, true, eggs.get(eggs.size() - 1).getId(), Color.RED);
                            break;
                        case '*':
                            bunny = new Bunny(new Position(i, j), Color.PURPLE);
                            grid[i][j] = new Cell(new Position(i, j), CellType.GROUND, true, bunny.getId(), Color.PURPLE);
                            break;
                        default:
                            throw new BoardConstructorException(" ");
                    }
                }
            }
        } catch (NullPointerException ignored) { }
        try {
            if (bunny == null || eggs.size() == 0 || goal_cells.size() == 0 || eggs.size() != goal_cells.size()) {
                throw new BoardConstructorException(" ");
            }

        } catch (BoardConstructorException e){
            System.out.println("Please check the board input within the file ");

        }

        Board board = new Board(size,grid,eggs,goal_cells,bunny);
        if(board == null){
            throw new NullPointerException("input can not be null");
        }

        return board;
    }


    public char[][] getGrid() {
        return this.grid;
    }


    public void printGrid() {
        int i, j;
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                System.out.print(this.grid[i][j] + "\t");
            }
            System.out.println();
        }
    }


}


// Print the 2D array for verification
//            for(char[]rowArray:array2D){
//                    for(char value:rowArray){
//                    System.out.print(value+" ");
//                    }
//                    System.out.println();
//                    }


// for init the board with width and height from input
//    int width, height;
//            width = columns;
//                    height = rows;
