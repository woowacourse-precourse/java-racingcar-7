package racingcar;

import controller.RacingController;
import util.RandomGenerator;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.run(new RandomGenerator());
    }
}
