package racingcar.domain.model;

import java.util.List;

public class RacingParticipants {
    private final List<Car> cars;

    private RacingParticipants(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingParticipants from(List<String> names) {
        return new RacingParticipants(
                names.stream()
                        .map(Car::of)
                        .toList()
        );
    }

    public void tryMove() {
        cars.forEach(Car::tryMove);
    }

    public List<Car> getCars() {
        return cars;
    }
}
