import Exceptions.BoardConstructorException;
import Logic.Game;
import Logic.Player;
import Logic.UserPlayer;
import Structure.Board;
import temp.ScanInputFile;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//                String file_path = "Input.txt";
//        ScanInputFile scan = new ScanInputFile(file_path);
//        scan.printGrid();
//        try {
////            Board board = new Board(scan.charToBoard(scan.grid));
//            System.out.println("***********************************");
//            System.out.println(scan.charToBoard(scan.getGrid()));
//        } catch (NullPointerException | BoardConstructorException e) {
//            System.out.println(e);
//        }
//        *******************************************************************************
        String file_path = "Input2.txt";
        ScanInputFile scan = new ScanInputFile(file_path);
        Board board = new Board(scan.getGrid());
        System.out.println(board);
    }
}
