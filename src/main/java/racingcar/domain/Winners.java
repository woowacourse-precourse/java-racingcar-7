package racingcar.domain;

import java.util.List;

public class Winners {
    private final List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners from(Cars cars) {
        return new Winners(findWinners(cars));
    }

    public List<Car> getWinners() {
        return winners;
    }

    private static List<Car> findWinners(Cars cars) {
        int maxDistance = findMaxDistance(cars);
        return cars.getCars()
                .stream()
                .filter(car -> car.getPosition() == maxDistance)
                .toList();
    }

    private static int findMaxDistance(Cars cars) {
        return cars.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
