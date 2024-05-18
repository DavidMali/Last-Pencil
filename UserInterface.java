import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);

    UserInterface() {
        this.sc = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void printWelcomeMessage() {
        displayMessage("\nWelcome to the Game!\n");
        displayMessage("The rules of the Game are simple: You get to decide how many pencils are used in each round.\n" +
                "Then, you and the other player/bot take turns taking 1-3 pencils from the pile until there is only 1 left.\n" +
                "Whoever takes the last pencil loses the round.\n");
        displayMessage("Type START to start a new game or EXIT to leave this program:");
    }

    public boolean getUserChoice() {
        while (true) {
            String userChoice = sc.nextLine();
            checkForExit(userChoice);
            if (userChoice.equalsIgnoreCase("start")) {
                return true;
            } else {
                System.out.println("Type START to start a new game or EXIT to leave this program:");
            }
        }
    }

    public int promptForNumberOfPencils() {
        System.out.println("How many pencils would you like to use:");
        while (true) {
            String numberOfPencils = sc.nextLine();
            checkForExit(numberOfPencils);
            if (validatePositiveIntInput(numberOfPencils)) {
                return Integer.parseInt(numberOfPencils);
            }
            System.out.println("The number of pencils should be numeric and positive.");
        }

    }

    public boolean validatePositiveIntInput(String input) {
        String numbers = "0123456789";
        char[] userInputCharacters = input.toCharArray();
        for (int i = 0; i < userInputCharacters.length; i++) {
            if (!numbers.contains(String.valueOf(userInputCharacters[i]))) {
                return false;
            }
        }
        if (Integer.valueOf(input) == 0) {
            return false;
        }
        return true;
    }

    public void checkForExit(String userInput) {
        if (userInput.equalsIgnoreCase("Exit")) {
            displayMessage("Exiting the program. Goodbye!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.exit(0);
            }
            System.exit(0);

        }
    }





}
