package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Car> winners;

    private Winners(Cars cars) {
        this.winners = getWinners(cars.getCars());
    }

    public static Winners from(Cars cars) {
        return new Winners(cars);
    }

    private List<Car> getWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        cars.forEach(car -> {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        });
        return winners;
    }
}
