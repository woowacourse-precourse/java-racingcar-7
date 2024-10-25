package racingcar.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import racingcar.controller.strategy.MoveStrategy;

public class Race implements Iterator<List<Car>> {

    private final List<Car> cars;
    private final Lap lap;

    public Race(final String carNames, final MoveStrategy moveStrategy, final String numberOfAttempts) {
        this.cars = parseAndValidateCarNames(carNames, moveStrategy);
        this.lap = new Lap(numberOfAttempts);
    }

    private List<Car> parseAndValidateCarNames(final String carNames, final MoveStrategy moveStrategy) {
        final List<String> names = parseCarNames(carNames);
        return names.stream()
                .map(name -> new Car(name, moveStrategy, 0))
                .toList();
    }

    private List<String> parseCarNames(final String carNames) {
        try {
            return Arrays.stream(carNames.split(",", -1))
                    .map(String::trim)
                    .toList();
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("자동차 이름 입력 형식이 잘못되었습니다.", e);
        }
    }

    @Override
    public boolean hasNext() {
        return lap.isRemaining();
    }

    @Override
    public List<Car> next() {
        if (!hasNext()) {
            throw new IllegalStateException("더 이상 시도할 수 없습니다.");
        }

        cars.forEach(Car::attemptMove);
        lap.proceed();
        return List.copyOf(cars);
    }

    public List<Car> finish() {
        if (hasNext()) {
            throw new IllegalStateException("경주가 완료되지 않았습니다.");
        }

        final int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차들이 존재하지 않습니다."));
    }
}
