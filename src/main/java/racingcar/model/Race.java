package racingcar.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import racingcar.controller.strategy.MoveStrategy;

public class Race implements Iterator<List<Car>> {

    private final List<Car> cars;
    private final MoveStrategy moveStrategy;
    private final Lap lap;

    public Race(final String carNames, final MoveStrategy moveStrategy, final String numberOfAttempts) {
        this.cars = parseAndValidateCarNames(carNames);
        this.moveStrategy = moveStrategy;
        this.lap = new Lap(numberOfAttempts);
    }

    private List<Car> parseAndValidateCarNames(final String carNames) {
        final List<String> names = parseCarNames(carNames);
        return names.stream()
                .map(name -> new Car(name, 0))
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

    /**
     * 경주에 남은 시도가 있는지 확인한다.
     *
     * @return 남은 시도가 있으면 true, 그렇지 않다면 false.
     */
    @Override
    public boolean hasNext() {
        return lap.isRemaining();
    }

    /**
     * 경주를 한 번 진행하고 각 자동차의 움직임을 시도한다.
     *
     * @return 현재 라운드가 진행된 후 자동차들의 위치를 포함한 리스트의 복사본.
     * @throws IllegalStateException 시도할 횟수가 더 이상 남아있지 않은 경우.
     */
    @Override
    public List<Car> next() {
        if (!hasNext()) {
            throw new IllegalStateException("더 이상 시도할 수 없습니다.");
        }

        this.attemptMove();
        lap.proceed();
        return List.copyOf(cars);
    }

    private void attemptMove() {
        cars.forEach(car -> {
            if (moveStrategy.isMovable()) {
                car.move();
            }
        });
    }

    /**
     * 모든 경주가 완료된 후 우승자를 결정한다.
     *
     * @return 가장 멀리 이동한 자동차들의 리스트.
     * @throws IllegalStateException 경주가 아직 완료되지 않은 경우.
     */
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
