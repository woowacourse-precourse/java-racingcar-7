package racingcar;

import racingcar.model.CarRacing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new CarRacing(new InputView(), new OutputView()).start();
    }
}
