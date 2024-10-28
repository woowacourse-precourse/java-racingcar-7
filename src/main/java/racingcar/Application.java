package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.util.Validator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarController carController = new RacingCarController();
        carController.start();
    }
}
