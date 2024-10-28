package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.NumberOverFour;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new RacingController(new InputView(), new OutputView(), new NumberOverFour(new RandomNumberGenerator(9))).run();
    }
}
