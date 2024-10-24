package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        this.carList.add(car);
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public String toString() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
