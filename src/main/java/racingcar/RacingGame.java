package racingcar;

import java.util.List;
import racingcar.car.Car;
import racingcar.io.OutputConsoleHandler;
import racingcar.provider.NumberProvider;
import racingcar.provider.RandomNumberProvider;

public class RacingGame {

    private static final String POSITIONAL_CAR_STATUS_SYMBOL = "-";

    private final NumberProvider numberProvider = new RandomNumberProvider();
    private final OutputConsoleHandler outputConsoleHandler = new OutputConsoleHandler();

    public void runGame(Cars cars) {

    }

    public void showCarsStatusForEachTrial(List<Car> cars) {

        for (Car car : cars) {
            String currentPositionalVisualStatus = car.changeCurrentPositionalStatusToVisual(
                    POSITIONAL_CAR_STATUS_SYMBOL);

            outputConsoleHandler.showCurrentCarStatus(currentPositionalVisualStatus);
        }

    }
}
