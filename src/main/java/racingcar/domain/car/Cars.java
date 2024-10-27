package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxMoveCount = getMaxMoveCount();
        List<Car> winners = new ArrayList<>();

        findWinners(maxMoveCount, winners);

        return winners;
    }

    private int getMaxMoveCount() {
        return cars.stream().mapToInt(Car::getMoveCount).max().orElse(0);
    }

    private void findWinners(int maxMoveCount, List<Car> winners) {
        for (Car car : cars) {
            checkCount(maxMoveCount, winners, car);
        }
    }

    private static void checkCount(int maxMoveCount, List<Car> winners, Car car) {
        if (car.getMoveCount() == maxMoveCount) {
            winners.add(car);
        }
    }
}
