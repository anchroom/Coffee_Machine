package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Print empty board
        Board board = new Board();
        board.printFormatBoard();

        int count = 0; // To count the number of pieces
        Gamer gamer = new Gamer('X'); // Gamer 'X' ready

        do {
            move(board, gamer); // Current gamer decision to move
            board.printFormatBoard(); // move in board
            count++;
            if (count == 9) {
                break;
            }
            gamer.nextGamer(); // Next gamer is ready
        } while (!board.isWin(count % 2 == 0 ? 'O' : 'X'));
        printResult(board);
    }

    private static void printResult(Board board) {
        final String DRAW = "Draw";
        final String X_WIN = "X wins";
        final String O_WIN = "O wins";

        if (board.isWin('X')) {
            System.out.println(X_WIN);
        } else if (board.isWin('O')) {
            System.out.println(O_WIN);
        } else {
            System.out.println(DRAW);
        }
    }

    private static void move(Board board, Gamer gamer) {
        char[] newInput = board.getInput().toCharArray();
        newInput[getIndexFromCoordinates(getLegalNumLine(getNumLine()), board)] = gamer.getGamer();
        String output = new String(newInput);

        board.setInput(output);
    }

    private static int parseCoordinateToIndex(int coordinate_x, int coordinate_y) {
        int index;

        // transfer coordinates to index in String
        switch (coordinate_y) {
            case 3:
                index = coordinate_x + coordinate_y - 4;
                break;

            case 2:
                index = coordinate_x + coordinate_y;
                break;

            case 1:
                index = coordinate_x + coordinate_y + 4;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + coordinate_y);
        }

        return index;
    }

    private static String getNumLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");
        String coordinates = scanner.nextLine();

        while (coordinates.matches("\\D+")) {
            System.out.println("You should enter numbers!");
            System.out.print("Enter the coordinates: ");
            coordinates = scanner.nextLine();
        }

        return coordinates;
    }

    private static String getLegalNumLine(String numLine) {
        String pattern = "[1-3] [1-3]";
        String output = numLine;

        while (!output.matches(pattern)) {
            System.out.println("Coordinates should be from 1 to 3!");
            output = getNumLine();
        }

        return output;
    }

    private static int getIndexFromCoordinates(String legalNumLine, Board board) {
        int coordinate_x = legalNumLine.charAt(0) - '0';
        int coordinate_y = legalNumLine.charAt(2) - '0';
        String input = board.getInput();

        while (!(input.charAt(parseCoordinateToIndex(coordinate_x, coordinate_y)) == ' ')) {
            System.out.println("This cell is occupied! Choose another one!");
            String newLegalNumLine = getLegalNumLine(getNumLine());
            coordinate_x = newLegalNumLine.charAt(0) - '0';
            coordinate_y = newLegalNumLine.charAt(2) - '0';
        }

        return parseCoordinateToIndex(coordinate_x, coordinate_y);
    }

}

class Board{
    private String input = "         ";// Initial Empty board

    public Board() {
    }

    public String getInput() {
        return input;
    }

    // Print board
    public void printFormatBoard() {
        System.out.printf("---------%n| %c %c %c |%n| %c %c %c |%n| %c %c %c |%n---------%n" , input.charAt(0),
                input.charAt(1), input.charAt(2), input.charAt(3), input.charAt(4), input.charAt(5), input.charAt(6),
                input.charAt(7), input.charAt(8));
    }

    // Parse board, check if game is finish
    public boolean isWin(char ch) {
        String winInLine = "(" + ch + "{3}" + "......|..." + ch + "{3}" + "...|......" + ch + "{3}" + ")";
        String winInColumn = ".*?" + ch + ".." + ch + ".." + ch + ".*?";
        String winInCatercorner = "(.." + ch + "." + ch + "." + ch + ".." + "|" + ch + "..." + ch + "..." + ch +")";

        return input.matches(winInCatercorner) || input.matches(winInColumn) || input.matches(winInLine);
    }

    public void setInput(String input) {
        this.input = input;
    }
}

class Gamer{
    char gamer; // In this problem, default 'X' go first

    public Gamer(char gamer) {
        this.gamer = gamer;
    }

    public char getGamer() {
        return gamer;
    }

    public void nextGamer() {
        gamer = gamer == 'X' ? 'O' : 'X';
    }
}