package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.MoveCondition;

public class Cars {
    private static final String FEED = "\n";
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCarsByNames(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::new));
    }

    public void progressRace() {
        cars.forEach(Cars::goOrStop);
    }

    public String toPrettyString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining(FEED)) + FEED;
    }

    public String getWinnersName() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> isWinner(car, maxPosition))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private static boolean isWinner(Car car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private static void goOrStop(Car car) {
        if (MoveCondition.isMoveable()) {
            car.forward();
        }
    }
}
