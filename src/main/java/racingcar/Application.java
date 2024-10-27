package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        RaceController raceController = new RaceController(inputView, outputView);
        raceController.run();
    }
}
