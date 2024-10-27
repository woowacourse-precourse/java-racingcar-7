package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.random.CarRandomNumber;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomNumberGenerator randomNumberGenerator = new CarRandomNumber();
        RacingController controller = new RacingController(new InputView(), new OutputView(), randomNumberGenerator);
        controller.run();
    }
}
