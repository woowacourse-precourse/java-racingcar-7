package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public String moveEach(RandomNumbers randomNumbers) {
        return cars.stream().map(car -> car.move(randomNumbers.getNextNumber())).collect(Collectors.joining("\n"));
    }

    public List<String> findTopRankers() {
        return findTopRankers(findMaxPosition());
    }

    public int count() {
        return cars.size();
    }

    private List<String> findTopRankers(int maxPosition) {
        List<String> topRankers = new ArrayList<>();
        for (Car car : cars) {
            topRankers = car.addTopRankers(topRankers, maxPosition);
        }
        return topRankers;
    }

    private int findMaxPosition() {
        int maxPosition = -1;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public static Cars create(String[] inputNames) {
        List<Car> carsToCreate = new ArrayList<>();
        for (String inputName : inputNames) {
            carsToCreate.add(Car.create(inputName));
        }
        return new Cars(carsToCreate);
    }
}
