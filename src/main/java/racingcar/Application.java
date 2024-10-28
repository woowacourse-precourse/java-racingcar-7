package racingcar;

import racingcar.Controller.Controller;
import racingcar.View.ConsoleInputView;
import racingcar.View.ConsoleOutputView;
import racingcar.ViewInterface.InputView;
import racingcar.ViewInterface.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        Controller controller = new Controller(inputView, outputView);
        controller.run();
    }
}