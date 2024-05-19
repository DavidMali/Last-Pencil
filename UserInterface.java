import java.util.Scanner;

public class UserInterface {
    private final Scanner sc;

    UserInterface() {
        this.sc = new Scanner(System.in);
    }

    public Game startGame() {
        System.out.println("Type START to start a new game or EXIT to leave this program:");
        while (true) {
            String userInput = sc.nextLine();
            switch (userInput.toUpperCase()) {
                case "START":
                    int numberOfPencils = promptForNumberOfPencils();
                    String player1Name = promptForPlayerName();
                    String player2Name = getPlayer2Name();
                    boolean player1First = determineFirstPlayer(player1Name, player2Name);
                    return new Game(numberOfPencils, player1Name, player2Name, player1First);
                case "EXIT":
                    System.out.println("Exiting the program. Goodbye!");
                    try {
                        //noinspection BusyWait
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.exit(0);
                    }
                    System.exit(0);
                default:
                    System.out.println("Type START to start a new game or EXIT to leave this program:");
            }
        }
    }

    public int promptForNumberOfPencils() {
        System.out.println("How many pencils would you like to use:");
        while (true) {
            String numberOfPencils = sc.nextLine();
            if (validatePositiveIntInput(numberOfPencils)) {
                return Integer.parseInt(numberOfPencils);
            }
            System.out.println("The number of pencils should be numeric and greater than 5");
        }

    }

    public boolean validatePositiveIntInput(String input) {
        String numbers = "0123456789";
        char[] userInputCharacters = input.toCharArray();
        for (char userInputCharacter : userInputCharacters) {
            if (!numbers.contains(String.valueOf(userInputCharacter))) {
                return false;
            }
        }
        return Integer.parseInt(input) > 5;
    }


    public String promptForPlayerName() {
        System.out.println("What is your name?");
        while (true) {
            String playerName = sc.nextLine();
            if (playerName.equalsIgnoreCase("LAST_PENCIL_BOT")) {
                System.out.println("Hey, that's my name :P\nChoose another name:");
                continue;
            }
            return playerName;
        }

    }

    public String promptForPlayer2Name() {
        System.out.println("What is the name of Player 2?");
        return sc.nextLine();
    }


    public String getPlayer2Name() {
        System.out.println("Do you want to play against a bot or another player (locally)?");
        System.out.println("Type BOT to play against a bot or the PLAYER to play against another player:");
        while (true) {
            String input = sc.nextLine();
            switch (input.toUpperCase()) {
                case "BOT":
                    return "LAST_PENCIL_BOT";
                case "PLAYER":
                    return promptForPlayer2Name();
                default:
                    System.out.println("Type BOT to play against a bot or the PLAYER to play against another player:");
            }
        }
    }

    public boolean determineFirstPlayer(String player1Name, String player2Name) {
        System.out.println("Who will be the first:\n1: " + player1Name.toUpperCase() + "\n2: " + player2Name.toUpperCase());
        while (true) {
            String userInput = sc.nextLine();
            switch (userInput.toUpperCase()) {
                case "1":
                    return true;
                case "2":
                    return false;
                default:
                    System.out.println("Type 1 or 2 to determine which player goes first:");
            }
        }

    }

}





