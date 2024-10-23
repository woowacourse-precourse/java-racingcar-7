package racingcar;

import racingcar.model.CarRacing;
import racingcar.model.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new InputValidator());
        OutputView outputView = new OutputView();
        CarRacing carRacing = new CarRacing(inputView, outputView);

        carRacing.start();
    }
}
