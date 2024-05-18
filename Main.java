import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.printWelcomeMessage();
        if (ui.getUserChoice()) {
            int numberOfPencils = ui.promptForNumberOfPencils();
        } else return;


        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pencils would you like to use:");
        String numbers = "0123456789";

        int numberOfPencils = 0;
        while (true) {
            boolean validInput = true;
            String userInput = scanner.nextLine();
            char[] userInputCharacters = userInput.toCharArray();
            for (int i = 0; i < userInputCharacters.length; i++) {
                if (!numbers.contains(String.valueOf(userInputCharacters[i]))) {
                    System.out.println("The number of pencils should be numeric");
                    validInput = false;
                    break;
                }
            }

            if (validInput) {
                if (Integer.valueOf(userInput) == 0) {
                    System.out.println("The number of pencils should be positive");
                    continue;
                }
                numberOfPencils = Integer.valueOf(userInput);
                break;
            }

        }
        String botPlayer = "John";
        String availablePlayers ="Jack, John";
        System.out.println("Who will be the first (Jack, John)");
        String currentPlayer = "";
        while (true) {
            currentPlayer = scanner.nextLine();
            if (!availablePlayers.contains(currentPlayer)) {
                System.out.println("Choose between Jack and John");
                continue;
            }
            break;
        }

        Random random = new Random();

        while (numberOfPencils > 0) {
            int pencilsTaken = 0;
            System.out.println("|".repeat(numberOfPencils) + "\n" + currentPlayer + "'s turn!");



            while (true) {
                if (botPlayer.equals(currentPlayer)) {
                    switch (numberOfPencils % 4) {
                        case 1:
                            pencilsTaken = random.nextInt(2) + 1;
                            System.out.println(pencilsTaken);
                            break;
                        case 0:
                            pencilsTaken = 3;
                            System.out.println(pencilsTaken);
                            break;
                        case 2:
                            pencilsTaken = 1;
                            System.out.println(pencilsTaken);
                            break;
                        case 3:
                            pencilsTaken = 2;
                            System.out.println(pencilsTaken);
                            break;
                    }
                    break;
                }
                boolean validInput = true;
                String userInput = scanner.nextLine();
                char[] userInputCharacters = userInput.toCharArray();
                for (int i = 0; i < userInputCharacters.length; i++) {
                    if (!numbers.contains(String.valueOf(userInputCharacters[i]))) {
                        System.out.println("Possible values: '1', '2' or '3'");
                        validInput = false;
                        break;
                    }
                }
                if (validInput) {
                    pencilsTaken = Integer.valueOf(userInput);
                    if (pencilsTaken != 1 && pencilsTaken != 2 && pencilsTaken != 3) {
                        System.out.println("Possible values: '1', '2' or '3'");
                        continue;
                    }
                    if (pencilsTaken > numberOfPencils) {
                        System.out.println("Too many pencils were taken");
                        continue;
                    }
                    break;
                }

            }

            numberOfPencils -= pencilsTaken;
            currentPlayer = currentPlayer.equals("Jack") ? "John" : "Jack";
        }

        System.out.println(currentPlayer + " won!"); */
    }

}