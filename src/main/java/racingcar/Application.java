package racingcar;

import racingcar.config.ConsoleCarRaceConfig;
import racingcar.domain.race.RandomCarRace;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceController randomRaceController = new RaceController(ConsoleCarRaceConfig.getInstance(), RandomCarRace.getInstance());
        randomRaceController.run();
    }
}
