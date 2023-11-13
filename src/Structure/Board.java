package Structure;

import Exceptions.BoardConstructorException;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private Cell[][] grid;
    private List<Egg> eggs;
    private List<Cell> goal_cells;
    private Bunny bunny;

    public Board(int size, Cell[][] grid, List<Egg> eggs, List<Cell> goal_cells, Bunny bunny) {
        this.size = size;
        this.grid = new Cell[size][size];
        this.grid = grid;
        this.eggs = new ArrayList<Egg>(eggs);
        this.goal_cells = new ArrayList<Cell>(goal_cells);
        this.bunny = new Bunny(bunny);
    }

//   pass the char [][] array, then the constructor make the board with all elements on this board
    public Board(char [][] grid) {
        try{
            if (grid == null)
                throw new BoardConstructorException("the grid can not be null");

            this.size = grid.length;
            this.grid = new Cell[size][size];
            this.goal_cells = new ArrayList<>();
            this.eggs = new ArrayList<Egg>();
            this.bunny = null;

            int i = 0, j = 0;
            for (i = 0; i < size; i++) {
                for (j = 0; j < size; j++) {

                    //construct the board for every char and make the cell type with all elements
                    //on the board

                    switch (grid[i][j]) {
                        case '#':
                            this.grid[i][j] = new Cell(new Position(i, j), CellType.STONE, false, -1, Color.WHITE);
                            break;
                        case '.':
                            this.grid[i][j] = new Cell(new Position(i, j), CellType.GROUND, false, -1, Color.Black);
                            break;
                        case '_':
                            this.grid[i][j] = new Cell(new Position(i, j), CellType.GOAL_CELL, false, -1, Color.YELLOW);
                            this.goal_cells.add(this.grid[i][j]);
                            break;
                        case '@':
                            this.eggs.add(new Egg(new Position(i, j), Color.RED));
                            this.grid[i][j] = new Cell(new Position(i, j), CellType.GROUND, true, this.eggs.get(eggs.size() - 1).getId(), Color.RED);
                            break;
                        case '*':
                            this.bunny = new Bunny(new Position(i, j), Color.PURPLE);
                            this.grid[i][j] = new Cell(new Position(i, j), CellType.GROUND, true, this.bunny.getId(), Color.PURPLE);
                            break;
                        default:
                            throw new BoardConstructorException("the board can not be have other type");
                    }

                }
            }

            if (this.bunny == null || this.eggs.isEmpty() || this.goal_cells.isEmpty() || this.eggs.size() != this.goal_cells.size()) {
                throw new BoardConstructorException("The board can not be played with this elements ");
            }

        }catch (BoardConstructorException e){
            System.out.println(e);
            System.exit(-1);
        }

    }


    public int getSize() {
        return size;
    }


    @Override
    public String toString() {
        int i, j;
        StringBuilder str = new StringBuilder();

        for (i = 0; i < this.size; i++) {
            for (j = 0; j < this.size; j++) {
                if(this.grid[i][j].getType() == CellType.STONE){
                    str.append(this.grid[i][j].getColor().getCode()).append("#").append(Color.RESET.getCode()).append("\t");
                }
                else if(this.grid[i][j].getType() == CellType.GOAL_CELL){
                    str.append(this.grid[i][j].getColor().getCode()).append("_").append(Color.RESET.getCode()).append("\t");
                }
                else {
                    if(this.grid[i][j].isOccupied()){
                        if(this.grid[i][j].getElementId() != this.bunny.getId()){
                            str.append(this.grid[i][j].getColor().getCode()).append("@").append(Color.RESET.getCode()).append("\t");
                        }else {
                            str.append(this.grid[i][j].getColor().getCode()).append("*").append(Color.RESET.getCode()).append("\t");
                        }
                    }
                    else
                    {
                        str.append(this.grid[i][j].getColor().getCode()).append(".").append(Color.RESET.getCode()).append("\t");
                    }

                }

            }
            str.append("\n");
        }

        return str.toString();
    }


//    private char shapOfElement(Cell c){
//        if(c.getType() == CellType.STONE)
//            return '#';
//        else if (c.getType() == CellType.GOAL_CELL)
//            return '_';
//        else {
//            if(c.isOccupied()){
//
//            }
//        }
//
//    }
//    @Override
//    public String toString() {
//        char[][] s = new char[this.size][this.size];
//        int i, j;
////      first print the board shape
//        for (i = 0; i < this.size; i++) {
//            for (j = 0; j < this.size; j++) {
//                if (this.grid[i][j].getType() == CellType.STONE) {
//                    s[i][j] = '#';
//                } else {
//                    s[i][j] = '.';
//                }
//            }
//        }
////        then we use the information in class board (eggs, bunny , goal cells) positions to print this elements
//        for (Egg e : eggs) {
//            s[e.position.getX()][e.position.getY()] = '@';
//        }
//
//        for (Cell c : goal_cells) {
//            s[c.getPosition().getX()][c.getPosition().getY()] = '_';
//        }
//
//        s[bunny.position.getX()][bunny.position.getY()] = '*';
//
////      print console
//        StringBuilder str = new StringBuilder();
//
//        for (i = 0; i < this.size; i++) {
//            for (j = 0; j < this.size; j++) {
//
//
//                str.append(s[i][j]).append("\t");
//            }
//            str.append("\n");
//        }
//
//        return str.toString();
//    }





}