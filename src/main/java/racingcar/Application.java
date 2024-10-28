package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameController gameController = new GameController(inputView, outputView);

        gameController.gameStart();
    }
}
