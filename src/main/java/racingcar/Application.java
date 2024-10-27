package racingcar;

public class Application {
    public static void main(String[] args) {

        MoveStrategy moveStrategy = new DefaultMoveStrategy();

        GameController gameController = new GameController(moveStrategy);
        gameController.run();
    }
}