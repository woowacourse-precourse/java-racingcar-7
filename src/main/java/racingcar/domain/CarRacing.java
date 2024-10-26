package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    private final List<Car> carList = new ArrayList<>();

    public CarRacing(List<String> cars) {
        for (String car : cars) {
            carList.add(new Car(car));
        }
    }

    public List<Car> getCars() {
        return carList;
    }

    public void go() {
        for (Car car : carList) {
            car.go();
        }
    }

    public String winnerList() {
        int maxPosition = getMaxPosition();

        return carList.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.joining(","));
    }

    private int getMaxPosition() {

        return carList.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }
}
