package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.utils.RandomNumberGenerator;
import racingcar.utils.RandomGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomGenerator randomNumberGenerator = new RandomNumberGenerator();
        RacingCarController racingCarController = new RacingCarController(randomNumberGenerator);
        racingCarController.run();
    }
}
