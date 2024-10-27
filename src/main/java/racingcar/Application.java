package racingcar;


public class Application {
    public static void main(String[] args) {

        GameConfig gameConfig = new GameConfig();

        GameController gameController = new GameController(gameConfig.gameService(), gameConfig.outputView(),
                gameConfig.inputView(), gameConfig.inputValidator());

        gameController.run();
    }
}
