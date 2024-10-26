package racingcar;

import racingcar.config.RaceConfig;
import racingcar.domain.CarFactory;
import racingcar.domain.CarRegistry;
import racingcar.domain.RaceResult;
import racingcar.domain.Stadium;
import racingcar.io.View;

public class RaceManager {
    private final CarFactory carFactory;
    private final View view;

    public RaceManager(CarFactory carFactory, View view) {
        this.carFactory = carFactory;
        this.view = view;
    }

    public void startGame(RaceConfig config) {
        String carNames = config.getCarNames();

        CarRegistry carRegistry = new CarRegistry(carFactory.createCars(carNames));
        RaceResult raceResult = new RaceResult(new StringBuilder(), carRegistry);
        Stadium stadium = new Stadium(carRegistry, raceResult);

        runGame(stadium, raceResult, config.getRounds());
    }

    private void runGame(Stadium stadium, RaceResult raceResult, int rounds) {
        stadium.runGame(rounds);

        view.printExecutionOutput(raceResult.toString());
        view.printWinner(raceResult.winnersToString());
    }
}
