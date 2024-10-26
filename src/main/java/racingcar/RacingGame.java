package racingcar;

import java.util.List;
import racingcar.car.Car;
import racingcar.io.OutputConsoleHandler;
import racingcar.provider.NumberProvider;
import racingcar.provider.RandomNumberProvider;

public class RacingGame {

    private static final int MOVING_DISTANCE_EACH_TRIAL = 1;
    private static final String POSITIONAL_CAR_STATUS_SYMBOL = "-";

    private final NumberProvider numberProvider = new RandomNumberProvider();
    private final OutputConsoleHandler outputConsoleHandler = new OutputConsoleHandler();

    public void tryMoveForward(List<Car> cars) {
        for (Car car : cars) {
            int value = numberProvider.getNumber();
            car.tryMoveForward(value, MOVING_DISTANCE_EACH_TRIAL);
        }
    }

    public void showCarsStatusForEachTrial(List<Car> cars) {

        for (Car car : cars) {
            String currentPositionalVisualStatus = car.changeCurrentPositionalStatusToVisual(
                    POSITIONAL_CAR_STATUS_SYMBOL);

            outputConsoleHandler.showCurrentCarStatus(currentPositionalVisualStatus);
        }

    }
}
