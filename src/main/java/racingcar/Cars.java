package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void print() {
        cars.forEach(car -> {
            car.print();
            System.out.println();
        });
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getWinners() {
        return getWinners(this.cars, getMaxMoveCount());
    }

    public static List<Car> getWinners(List<Car> cars, MoveCount maxMoveCount) {
        List<Car> winners = new ArrayList<>();
        cars.stream()
                .filter(car -> car.isWinner(maxMoveCount))
                .forEach(winners::add);
        return winners;
    }

    private MoveCount getMaxMoveCount() {
        return cars.stream()
                .map(Car::getMoveCount)
                .max(Comparator.naturalOrder())
                .orElse(new MoveCount(0));
    }
}
