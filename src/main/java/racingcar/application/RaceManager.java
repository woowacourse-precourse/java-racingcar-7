package racingcar.application;

import racingcar.config.AppConfig;
import racingcar.config.RaceConfig;
import racingcar.domain.car.CarFactory;
import racingcar.domain.car.CarRegistry;
import racingcar.domain.race.RaceResult;
import racingcar.domain.race.Stadium;
import racingcar.presentation.io.View;

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
