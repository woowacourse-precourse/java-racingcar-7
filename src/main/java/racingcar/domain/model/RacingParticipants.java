package racingcar.domain.model;

import java.util.List;

public class RacingParticipants {
    private static final String FIND_MAX_FAILURE_MESSAGE = "Move Count의 최대값을 찾을 수 없습니다.";

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

    public List<String> findWinnerNames() {
        int maxMoveCount = findMaxMoveCount();
        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .toList();
    }

    private int findMaxMoveCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElseThrow(
                        () -> new IllegalArgumentException(FIND_MAX_FAILURE_MESSAGE)
                );
    }
}
