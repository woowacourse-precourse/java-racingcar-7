package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    // 생성자
    public Cars(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public void moveAllCars(int moveThreshold, int randomValue) {
        for (Car car : cars) {
            if (randomValue >= moveThreshold) {
                car.move();
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPositionValue() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPositionValue)
                .max()
                .orElse(0);
    }
}
