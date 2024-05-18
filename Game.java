import java.util.Random;
import java.util.Scanner;

public class Game {
    private int numberOfPencils;
    private String player1Name;
    private String player2Name;
    private boolean player1First;
    private Random random;
    private Scanner scanner;

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
            int pencilsTaken = 0;
            System.out.println("|".repeat(numberOfPencils) + "\n" + currentPlayer + "'s turn!");
            while (true) {
                if (currentPlayer.equals("LAST_PENCIL_BOT")) {
                    pencilsTaken = doBotTurn(numberOfPencils);
                    System.out.println(pencilsTaken);
                    break;
                }
                pencilsTaken = doPlayerTurn(numberOfPencils);
                break;
            }
            numberOfPencils -= pencilsTaken;
            currentPlayer = currentPlayer.equals(player2Name) ? player1Name : player2Name;
        }
        System.out.println(currentPlayer + " won!\n");
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

    public int doPlayerTurn(int numberOfPencils) {
        int pencilsTaken = 0;
        while (pencilsTaken == 0) {
            String userInput = scanner.nextLine();
            if (isValidInput(userInput)) {
                pencilsTaken = Integer.parseInt(userInput);
            }
        }
        return pencilsTaken;
    }

    public boolean isValidInput(String input) {
        String numbers = "0123456789";
        int pencilsTaken = 0;
        char[] userInputCharacters = input.toCharArray();
        for (int i = 0; i < userInputCharacters.length; i++) {
            if (!numbers.contains(String.valueOf(userInputCharacters[i]))) {
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
}






