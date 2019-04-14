public class MyTicTacToe {

    public static final char SYMBOL_X = 'X';
    public static final char SYMBOL_0 = '0';

    //char[][] game = new char[3][3];
    public static final int GAME_SIZE = 3;
    char[][] game = new char[GAME_SIZE][GAME_SIZE];

    Player player1;
    Player player2;

    public MyTicTacToe(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }


    public void showGamee(){
        for(int i = 0; i < GAME_SIZE; i++){
            for(int j = 0; j < GAME_SIZE; j++){
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void initBoard(){
        for(int i = 0; i < GAME_SIZE; i++){
            for( int j = 0; i < GAME_SIZE; j++){
                game[i][j] = '.';
            }
        }
    }

    public boolean isWin(){
        //testez linii
        //testez coloane
        //testez diag1
        //testez diag2
        return false;

    }
    public void playGame(){
        initBoard();
        System.out.println("incepe jocul.");
        showGamee();

        Player currentPlayer = player1;
        int nrMoves = 0;
        boolean isWin = false;

        while(isWin == false && nrMoves < 9){

            //citesc mutarea
            //validez mutarea
            //efectuez mutare
            //numar mutare
            //testez daca avem stare de Win

            // daca nu e win sau mai am mutari -- schimb jucatorul
        }

        //afisez mesaj corescpunzator
    }
}
