package racingcar;

import racingcar.adapters.input.RaceCliInputAdapter;
import racingcar.infrastructure.config.AppConfig;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RaceCliInputAdapter raceCliInputAdapter = appConfig.getRaceCliInputAdapter();

        raceCliInputAdapter.startRace();
    }
}
