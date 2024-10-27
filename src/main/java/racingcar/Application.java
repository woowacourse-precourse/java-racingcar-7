package racingcar;

import racingcar.config.AppConfig;
import racingcar.config.RaceConfig;


public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        ApplicationReader applicationReader = ApplicationReader.getInstance(appConfig.createInput(), appConfig.createView());

        RaceConfig raceConfig = applicationReader.readRaceConfig();
        RaceManager raceManager = new RaceManager(appConfig.createCarFactory(), appConfig.createView());

        raceManager.startRace(raceConfig);
    }
}
