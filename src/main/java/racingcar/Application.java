package racingcar;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new InputHandler(), new GameView());
        game.start();
    }
}
