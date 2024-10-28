package racingcar.domain;

import racingcar.exception.ExceptionMessage;
import racingcar.util.RandomDigitGenerator;
import racingcar.view.OutputView;
import java.util.List;

public class RacingGameController {

    private final List<Car> cars;
    private final int tryCount;
    private final RandomDigitGenerator rdg;
    private final OutputView outputView;

    public RacingGameController(Cars cars, int tryCount, RandomDigitGenerator rdg, OutputView outputView) {
        validTryCount(tryCount);
        this.cars = cars.getCars();
        this.tryCount = tryCount;
        this.rdg = rdg;
        this.outputView = outputView;
    }

    public void playGame() {

        for (int i = 0; i < tryCount; i++) {
            moveCarsForCurrentTry();
            outputView.printPositions(cars);
        }
    }

    private void moveCarsForCurrentTry() {
        for (Car car : cars) {
            int digit = rdg.generateDigit();
            car.moveForwardIfDigitAboveThreshold(digit);
        }
    }

    public List<String> getWinner() {
        int max = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);

        return cars.stream().filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .toList();
    }

    private void validTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_TRY_COUNT);
        }
    }
}
