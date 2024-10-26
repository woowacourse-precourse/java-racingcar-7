package racingcar.model;

import java.util.List;
import racingcar.constants.ErrorMessages;

public class RacingGame {
    private final Cars cars;
    private final int tryCount;

    public RacingGame(Cars cars, int tryCount) {
        validateTryCount(tryCount);
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<String> getFinalWinner() {
        return this.cars.getFinalWinners().stream()
                .map(CarName::getRacerName)
                .toList();
    }

    public List<Car> getOneCycleResult() {
        cars.doOneCycle();

        return cars.getCars();
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_TRY_COUNT.getMessage());
        }
    }
}
