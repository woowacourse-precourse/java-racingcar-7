package racingcar;


public class Application {
    public static void main(String[] args) {
        GameController gameController = GameFactory.createGameController();
        gameController.run();
    }
}
