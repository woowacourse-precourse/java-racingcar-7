package racingcar.model;

import static racingcar.constants.Constants.MIN_TRY_COUNT;

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
        return cars.getFinalWinners().stream()
                .map(CarName::getName)
                .toList();
    }

    public String getRacingResult() {
        return cars.getGameResult();
    }

    public void runAllCycle() {
        for (int i = 0; i < tryCount; i++) {
            runOneCycle();
        }
    }

    private void runOneCycle() {
        cars.moveAllCars();
    }

    private void validateTryCount(String tryCount) {
        validateInt(tryCount);
        validateOverZero(Integer.parseInt(tryCount));
    }

    private void validateOverZero(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
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
