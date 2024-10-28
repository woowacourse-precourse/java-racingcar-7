package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final int MIN_DUPLICATE_NAME = 1;
    public static final String WINNER_DELIMITER = ", ";
    private final List<Car> cars;

    public Cars(String[] players) {
        validDuplicate(players);
        this.cars = Arrays.stream(players)
                .map(Car::new)
                .toList();
    }

    private void validDuplicate(String[] players) {
        long duplicateCount = calculateDuplicate(players);
        if (duplicateCount >= MIN_DUPLICATE_NAME) {
            throw new IllegalArgumentException("같은 이름을 사용할 수 없습니다");
        }
    }

    private long calculateDuplicate(String[] players) {
        return Arrays.stream(players)
                .filter(player -> Arrays.stream(players).filter(player::equals).count() > 1)
                .distinct()
                .count();
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }


    public void tryMove(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generateNumber()));
    }

    public String getWinners() {
        int maxLocation = cars.stream().map(Car::getLocation).max(Integer::compareTo).get();
        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

}
