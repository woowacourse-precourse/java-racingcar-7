package racingcar.model;

import java.util.List;
import racingcar.constants.ErrorMessages;

public class RacingGame {
    private final Cars cars;
    private final int tryCount;

    public RacingGame(Cars cars, String tryCount) {
        validateTryCount(tryCount);
        this.cars = cars;
        this.tryCount = Integer.parseInt(tryCount);
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

    private void validateTryCount(String tryCount) {
        validateInt(tryCount);
        validateOverZero(Integer.parseInt(tryCount));
    }

    private void validateOverZero(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_TRY_COUNT.getMessage());
        }
    }

    private void validateInt(String tryCount) {
        if (!isInt(tryCount)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInt(String tryCount) {
        return tryCount.chars().allMatch(Character::isDigit);
    }
}
