package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int moveCount;
    private final MoveStrategy moveStrategy;
    private int currentRound = 0;

    public RacingGame(List<String> carNames, int moveCount, MoveStrategy moveStrategy) {
        RacingGameValidator.validateMoveCount(moveCount);
        this.cars = createCars(carNames);
        this.moveCount = moveCount;
        this.moveStrategy = moveStrategy;
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public boolean hasNextRound() {
        return currentRound < moveCount;
    }

    public void playNextRound() {
        if (!hasNextRound()) {
            throw new IllegalStateException("더 이상 진행할 라운드가 없습니다.");
        }
        moveCars();
        currentRound++;
    }

    public void playAllRounds() {
        while (hasNextRound()) {
            playNextRound();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
