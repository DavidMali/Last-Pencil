import java.util.Random;
import java.util.Scanner;

public class Game {
    private int numberOfPencils;
    private final String player1Name;
    private final String player2Name;
    private final boolean player1First;
    private final Random random;
    private final Scanner scanner;

    Game(int numberOfPencils, String player1Name, String player2Name, boolean player1First) {
        this.numberOfPencils = numberOfPencils;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1First = player1First;
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        String currentPlayer = player1First ? player1Name : player2Name;
        while (numberOfPencils > 0) {
            int pencilsTaken;
            System.out.println("|".repeat(numberOfPencils) + "\n" + currentPlayer + "'s turn!");

            if (currentPlayer.equals("LAST_PENCIL_BOT")) {
                pencilsTaken = doBotTurn(numberOfPencils);
                System.out.println(pencilsTaken);
            } else {
                pencilsTaken = doPlayerTurn();
            }

            numberOfPencils -= pencilsTaken;
            currentPlayer = currentPlayer.equals(player2Name) ? player1Name : player2Name;
        }
        announceWinner(currentPlayer);

        startAgain();
    }

    public int doBotTurn(int numberOfPencils) {
        switch (numberOfPencils % 4) {
            case 1:
                return random.nextInt(2) + 1;
            case 0:
                return 3;
            case 2:
                return 1;
            case 3:
                return 2;
        }
        return 0;
    }

    public int doPlayerTurn() {
        int pencilsTaken = 0;
        while (pencilsTaken == 0) {
            String userInput = scanner.nextLine();
            if (checkInput(userInput)) {
                pencilsTaken = Integer.parseInt(userInput);
            }
        }
        return pencilsTaken;
    }

    public boolean checkInput(String input) {
        String numbers = "0123456789";
        int pencilsTaken;
        char[] userInputCharacters = input.toCharArray();
        for (char userInputCharacter : userInputCharacters) {
            if (!numbers.contains(String.valueOf(userInputCharacter))) {
                System.out.println("Possible values: '1', '2' or '3'");
                return false;
            }
        }
        pencilsTaken = Integer.parseInt(input);
        if (pencilsTaken != 1 && pencilsTaken != 2 && pencilsTaken != 3) {
            System.out.println("Possible values: '1', '2' or '3'");
            return false;
        }
        if (pencilsTaken > numberOfPencils) {
            System.out.println("Too many pencils were taken");
            return false;
        }
        return true;
    }

    public void announceWinner(String winnerName) {
        System.out.println(winnerName + " won!\n");
    }

    public void startAgain() {
        UserInterface ui = new UserInterface();
        Game game = ui.startGame();
        game.play();
    }
}






