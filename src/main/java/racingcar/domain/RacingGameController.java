package racingcar.domain;

import racingcar.exception.ExceptionMessage;
import racingcar.util.RandomDigitGenerator;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {

    private List<Car> cars;
    private int tryCount;
    private RandomDigitGenerator rdg;
    private OutputView outputView;

    public RacingGameController(Cars cars, int tryCount, RandomDigitGenerator rdg, OutputView outputView) {
        validTryCount(tryCount);
        this.cars = cars.getCars();
        this.tryCount = tryCount;
        this.rdg = rdg;
        this.outputView = outputView;
    }

    public void playGame() {

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                int digit = rdg.generateDigit();
                car.moveForwardIfDigitAboveThreshold(digit);
            }
            outputView.printPositions(cars);
        }
    }

    public List<String> getWinner() {
        int max = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);

        List<Car> winner = cars.stream().filter(car -> car.getPosition() == max)
                .toList();

        return winner.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_TRY_COUNT);
        }
    }
}
