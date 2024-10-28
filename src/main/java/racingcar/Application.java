package racingcar;

import racingcar.car.RacingCarController;
import racingcar.racing.RacingController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarController racingCarController = new RacingCarController();
        RacingController racingController = new RacingController();
        racingController.start(racingCarController.registerRacingCars());
    }
}
