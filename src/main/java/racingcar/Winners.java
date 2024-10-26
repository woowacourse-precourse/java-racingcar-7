package racingcar;

import java.util.List;

public class Winners {

    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> findWinners(List<Integer> positions) {
        return findWinners(cars, determineWinnerPosition(positions));
    }

    public static List<String> findWinners(List<Car> cars, int winnerPosition) {
        return cars.stream()
                .filter(car -> car.isWinnerPosition(winnerPosition))
                .map(Car::getName)
                .toList();
    }

    private static int determineWinnerPosition(List<Integer> positions) {
        return positions.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }
}
