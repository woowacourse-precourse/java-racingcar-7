package racingcar;

import java.util.List;

public class Winners {

    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> findWinners(List<Position> positions) {
        return findWinners(cars, determineWinnerPosition(positions));
    }

    public static List<String> findWinners(List<Car> cars, int winnerPosition) {
        return cars.stream()
                .filter(car -> car.isWinnerPosition(winnerPosition))
                .map(Car::getName)
                .toList();
    }

    private static int determineWinnerPosition(List<Position> positions) {
        return positions.stream()
                .map(Position::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
