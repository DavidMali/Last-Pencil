public class Main {
    public static void main(String[] args) {
        printWelcomeMessage();
        while (true) {
            UserInterface ui = new UserInterface();
            Game game = ui.startGame();
            game.play();
        }

    }

    public static void printWelcomeMessage() {
        System.out.println("\nWelcome to the Game!\n");
        System.out.println("The rules of the Game are simple: You get to decide how many pencils are used in each round.\n" +
                "Then, you and the other player/bot take turns taking 1-3 pencils from the pile until there is only 1 left.\n" +
                "Whoever takes the last pencil loses the round.\n");
    }
}