import java.util.Scanner;

public class MyTicTacToe {

    public static final char SYMBOL_X = 'X';
    public static final char SYMBOL_0 = '0';

    //char[][] game = new char[3][3];
    public static final int GAME_SIZE = 3;
    char[][] game = new char[GAME_SIZE][GAME_SIZE];

    Player player1;
    Player player2;

    public MyTicTacToe(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    public void showGamee() {
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void initBoard() {
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                game[i][j] = '.';
            }
        }
    }

    public Move readMove() {
        Scanner s = new Scanner(System.in);
        System.out.print("intoducere mouve");
        String myMove = s.nextLine();
        String[] mySplit = myMove.split("-");
        Integer myLine = Integer.valueOf(mySplit[0]);
        Integer myCol = Integer.valueOf(mySplit[1]);

        Move move = new Move(myLine, myCol);
        return move;
    }

    public void makeMove(Move move, char symbol) {
        game[move.line][move.col] = symbol;
    }

    public boolean validare (Move move){
        if (game[move.line][move.col] !=  '.') {
            System.out.println("incearca alta pozitie");
            System.out.println();
            return false;
        }
        return true;
    }

    public boolean isWinLine(int line, char symbol) {
        boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE && isWin == true) {
            if (game[line][i] != symbol) {
                isWin = false;
            }
            i++;
        }
        return isWin;

    }

    public boolean isWinCol(int col, char symbol) {
        boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE && isWin == true) {
            if (game[i][col] != symbol) {
                isWin = false;
            }
            i++;
        }
        return isWin;

    }

    public boolean isWinDiag1(char symbol) {
        boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE && isWin == true) {
            if (game[i][i] != symbol) {
                isWin = false;
            }
            i++;
        }
        return isWin;
    }

    public boolean isWinDiag2(char symbol) {
        boolean isWin = true;
        int i = 0;
        while (i < GAME_SIZE && isWin == true) {
            if (game[i][GAME_SIZE - i - 1] != symbol) {
                isWin = false;
            }
            i++;
        }
        return isWin;
    }

    public boolean isWin(Move move, char symbol) {
        boolean isWin = false;
        //testez linii
        isWin = isWinLine(move.line, symbol);
        if (isWin == false) {
            //testez coloane
            isWin = isWinCol(move.col, symbol);
        }
        //testez diag1
        if (isWin == false && move.line == move.col) {
            isWin = isWinDiag1(symbol);
        }
        //testez diag2
        if (isWin == false && move.line == GAME_SIZE - move.col - 1) {
            isWin = isWinDiag2(symbol);
        }
        return isWin;

    }

    public void playGame() {
        initBoard();
        System.out.println("incepe jocul.");
        showGamee();

        Player currentPlayer = player1;
        char currentSymbol = SYMBOL_X;

        int nrMoves = 0;
        boolean isWin = false;

        while (isWin == false && nrMoves < (GAME_SIZE * GAME_SIZE)) {

            //citesc mutarea
            Move move = readMove();
            System.out.println(move.line);
            System.out.println(move.col);
            //validez mutarea
            move = validezSiInscriu(move);
            //efectuez mutare
            makeMove(move, currentSymbol);
            showGamee();

            //numar mutare
            nrMoves++;
            if (nrMoves >= (2 * GAME_SIZE - 1)) {
                //testez daca avem stare de Win
                isWin = isWin(move, currentSymbol);
            }

            // daca nu e win sau mai am mutari -- schimb jucatorul
            if (!isWin) {
                if (currentPlayer == player1) {
                    currentPlayer = player2;
                    currentSymbol = SYMBOL_0;
                } else {
                    currentPlayer = player1;
                    currentSymbol = SYMBOL_X;
                }
            }
        }

        //afisez mesaj corescpunzator
        if (isWin) {
            System.out.println("a cistigat" + currentPlayer.name);
        } else {
            System.out.println("nu a cistigat nimeni");
        }
        restartGame();
    }

    private void restartGame() {
        System.out.println("Dorit sa jucate? Yes/no");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        if(response.toLowerCase().equals("yes")){
            playGame();
        }
    }

    private Move validezSiInscriu(Move move) {

        boolean valid= false;
        while (valid != true){
            valid = validare(move);
            if(valid == false){
                move = readMove();
            }
        }
        return move;
    }
}

