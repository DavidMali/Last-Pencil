public class Game {
    private int numberOfPencils;
    private String player1Name;
    private String player2Name;
    private boolean player1First;
    private boolean botGame = false;

    Game(int numberOfPencils, String player1Name, String player2Name, boolean player1First) {
        this.numberOfPencils = numberOfPencils;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1First = player1First;
        if (player2Name.equals("LAST_PENCIL_BOT")) {
            this.botGame = true;
        }
    }


    public void printGame() {
        System.out.println("Player 1: " + player1Name);
        System.out.println("Player 2: " + player2Name);
    }




}
