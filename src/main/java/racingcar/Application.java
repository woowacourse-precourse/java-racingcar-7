package racingcar;

import racingcar.config.ConsoleCarRaceConfig;
import racingcar.controller.RaceController;
import racingcar.domain.race.RandomCarRace;

public class Application {
    public static void main(String[] args) {
        RaceController randomRaceController = new RaceController(ConsoleCarRaceConfig.getInstance(), RandomCarRace.getInstance());
        randomRaceController.run();
    }
}
