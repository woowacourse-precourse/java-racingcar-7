package racingcar;

public class Application {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();
        GameController controller = new GameController(input, output);

        controller.run();
    }
}
