package racingcar;

import java.util.List;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<Car> cars = inputView.inputCarNames();
        int attemptCount = inputView.inputAttemptCount();
        Racing racing = new Racing(cars, attemptCount);

        outputView.printRacingResult(racing);
        outputView.printFinalWinners(racing);
    }
}
