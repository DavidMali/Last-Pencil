public class Game {
    private int numberOfPencils;
    private String player1Name;
    private String player2Name;
    private boolean player1First;

    Game(int numberOfPencils, String player1Name, String player2Name, boolean player1First) {
        this.numberOfPencils = numberOfPencils;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1First = player1First;
    }

    Game(int numberOfPencils, String player1Name, boolean player1First) {
        this.numberOfPencils = numberOfPencils;
        this.player1Name = player1Name;
        this.player1First = player1First;
    }


}
