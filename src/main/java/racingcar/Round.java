package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private static final String ERROR_MOVE_COUNT_NOT_IN_RANGE = "횟수는 1 이상 80 이하의 숫자만 가능합니다.";
    private final CompeteCars cars;
    private Integer moveCount;

    private void validateMoveCountInRange(Integer moveCount) {
        if (moveCount <= 0 || moveCount > 80) {
            throw new IllegalArgumentException(ERROR_MOVE_COUNT_NOT_IN_RANGE);
        }
    }

    public Round(Integer moveCount, CompeteCars cars) {
        validateMoveCountInRange(moveCount);
        this.moveCount = moveCount;
        this.cars = cars;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void progress() {
        cars.getAll().forEach(Car::move);
        moveCount--;
    }

    public String getResult() {
        return cars.getAll().stream().map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
            .collect(Collectors.joining("\n"));
    }

    public List<String> getWinners() {
        int maxPosition = cars.getAll().stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.getAll().stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName).toList();
    }
}
