package racingcar;

import racingcar.config.AppConfig;
import racingcar.config.RaceConfig;
import racingcar.car.CarFactory;
import racingcar.car.CarRegistry;
import racingcar.race.RaceResult;
import racingcar.race.Stadium;
import racingcar.io.View;

public class RaceManager {
    private final AppConfig appConfig;
    private final View view;

    public RaceManager(AppConfig appConfig) {
        this.appConfig = appConfig;
        this.view = appConfig.createView();
    }

    public void startRace(RaceConfig raceConfig) {
        String carNames = raceConfig.getCarNames();
        CarFactory carFactory = appConfig.createCarFactory();

        CarRegistry carRegistry = appConfig.createCarRegistry(carFactory.createCars(carNames));
        RaceResult raceResult = appConfig.createRaceResult(carRegistry);
        Stadium stadium = appConfig.createStadium(carRegistry, raceResult);

        stadium.raceEachRounds(raceConfig.getRounds());

        viewRaceResult(raceResult);
    }

    private void viewRaceResult(RaceResult raceResult) {
        view.printExecutionOutput(raceResult.toString());
        view.printWinner(raceResult.winnersToString());
    }
}
