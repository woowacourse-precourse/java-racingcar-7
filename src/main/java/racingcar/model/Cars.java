package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.util.RandomGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(String rawCarsName) {
        validateCarsName(rawCarsName);
        this.cars = initCars(rawCarsName);
    }

    private void validateCarsName(String carsName) {
        String[] parts = carsName.split(",");
        Set<String> uniqueNames = new HashSet<>();

        for (String name : parts) {
            if (hasDuplicateName(uniqueNames, name)) {
                throw new IllegalArgumentException("자동차 이름에 중복된 값이 있습니다.");
            }
        }
    }

    private boolean hasDuplicateName(Set<String> uniqueNames, String name) {
        return !uniqueNames.add(name);
    }

    private List<Car> initCars(String carsName) {
        String[] parts = carsName.split(",");
        return Arrays.stream(parts)
                .map(CarName::new)
                .map(Car::new)
                .toList();
    }

    public void moveCars() {
        for (Car car : cars) {
            if (RandomGenerator.Movable()) {
                car.forwardDistance();
            }
        }
    }

    public String getCarsDistance() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car).append("\n");
        }
        return result.toString();
    }

    private Integer getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    public String getWinner() {
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (findMaxDistance(car)) {
                winner.add(car.getName());
            }
        }
        return String.join("," + " ", winner);
    }

    private boolean findMaxDistance(Car car) {
        return car.getDistance().equals(getMaxDistance());
    }
}
