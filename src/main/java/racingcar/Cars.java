package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> carList = new ArrayList<>();

    public void add(Car car) {
        carList.add(car);
    }

    public void moveAll() {
        carList.forEach(Car::move);
    }

    public void showAll() {
        carList.forEach(Car::show);
        System.out.println();
    }

    public List<String> getWinners() {
        int maxDistance = carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
