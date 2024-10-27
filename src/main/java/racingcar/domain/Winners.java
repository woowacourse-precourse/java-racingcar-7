package racingcar.domain;

import java.util.List;

public class Winners {
    private final List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners from(Cars cars) {
    }

    private static int findMaxDistance(Cars cars) {
        return cars.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
