package racingcar;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final MoveCondition moveCondition;

    public RacingGame(Cars cars, MoveCondition moveCondition) {
        this.cars = cars;
        this.moveCondition = moveCondition;
    }

    public List<Integer> race() {
        return cars.move(moveCondition);
    }

    public List<String> getWinners(List<Integer> positions) {
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == getMaxPosition(positions))
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition(List<Integer> positions) {
        return positions.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    public List<Integer> getPositions() {
        return cars.getCars()
                .stream()
                .map(Car::getPosition)
                .toList();
    }
}
