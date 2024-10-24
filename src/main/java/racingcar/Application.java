package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.Race;

public class Application {
    private static final Race race = new Race();
    private static final RacingController racingController = new RacingController(race);

    public static void main(String[] args) {
        racingController.run();
    }
}
