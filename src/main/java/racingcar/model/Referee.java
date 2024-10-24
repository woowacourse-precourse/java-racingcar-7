package racingcar.model;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Referee {
    public Winners determineWinners(List<Car> cars) {
        int maxForwardLevel = findMaxForwardLevel(cars);
        return new Winners(findWinnerNames(cars, maxForwardLevel));
    }

    private int findMaxForwardLevel(List<Car> cars) {
        return cars.stream()
                .mapToInt(c -> c.getForwardLevel())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    private List<String> findWinnerNames(List<Car> cars, int maxForwardLevel) {
        return cars.stream()
                .filter(c -> c.getForwardLevel() == maxForwardLevel)
                .map(c -> c.getName())
                .collect(Collectors.toList());
    }
}
