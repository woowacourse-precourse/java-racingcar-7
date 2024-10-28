package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final RacingController racingController = new RacingController();
        racingController.run(new RandomNumberGenerator());
    }
}
