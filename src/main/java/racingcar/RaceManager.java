package racingcar;

import racingcar.config.RaceConfig;
import racingcar.car.CarFactory;
import racingcar.car.CarRegistry;
import racingcar.race.RaceResult;
import racingcar.race.Stadium;
import racingcar.io.View;

public class RaceManager {
    private final CarFactory carFactory;
    private final View view;

    public RaceManager(CarFactory carFactory, View view) {
        this.carFactory = carFactory;
        this.view = view;
    }

    public void startRace(RaceConfig config) {
        String carNames = config.getCarNames();

        CarRegistry carRegistry = new CarRegistry(carFactory.createCars(carNames));
        RaceResult raceResult = new RaceResult(new StringBuilder(), carRegistry);
        Stadium stadium = new Stadium(carRegistry, raceResult);

        race(stadium, raceResult, config.getRounds());
    }

    private void race(Stadium stadium, RaceResult raceResult, int rounds) {
        stadium.raceEachRounds(rounds);

        view.printExecutionOutput(raceResult.toString());
        view.printWinner(raceResult.winnersToString());
    }
}
