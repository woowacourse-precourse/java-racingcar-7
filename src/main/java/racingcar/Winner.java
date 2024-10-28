package racingcar;

import java.util.List;

public class Winner {
    public List<String> getBy(List<Car> finalResult) {
        int maxMoveCount = getMaxMoveCount(finalResult);
        return finalResult.stream()
                .filter(car -> car.getMovingCount() == maxMoveCount)
                .map(Car::getName)
                .toList();
    }

    private int getMaxMoveCount(List<Car> finalResult) {
        return finalResult.stream()
                .mapToInt(Car::getMovingCount)
                .max()
                .orElse(0);
    }
}
