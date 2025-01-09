package racingcar;

import exception.CustomIllegalArgException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void playRacing() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void printRacingResult() {
        for (Car car : cars) {
            car.printCarInfo();
        }
    }

    public List<String> getForwardInfos() {
        List<String> forwardInfos = new ArrayList<>();
        for (Car car : cars) {
            forwardInfos.add(car.carForwardInfo());
        }
        return forwardInfos;
    }

    public List<String> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new CustomIllegalArgException("No cars found"));

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
