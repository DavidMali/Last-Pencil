public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.printWelcomeMessage();
        Game game = ui.startGame();
        game.play();
    }

}