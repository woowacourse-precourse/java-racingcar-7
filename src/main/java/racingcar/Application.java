package racingcar;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new InputHandler(), new OutputHandler());
        game.start();
    }
}
