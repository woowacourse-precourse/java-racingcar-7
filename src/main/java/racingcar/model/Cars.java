package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.utils.Validator;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        validate();
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    private void validate() {
        Validator.containDuplicate(fetchCarNames());
    }

    public void allMove() {
        for (Car car : cars) {
            car.move(new RandomMovementStrategy());
        }
    }

    public List<String> findRaceWinners() {
        int maxDistance = findMaxDistance();
        return findWinners(maxDistance);
    }

    private List<String> findWinners(int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxDistance == car.getDistance()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int findMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            if (maxDistance < car.getDistance()) {
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }

    public List<String> fetchCarNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return List.copyOf(carNames);
    }

    public List<Integer> fetchCarsPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getDistance());
        }
        return List.copyOf(positions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }

}
