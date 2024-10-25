package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = new ArrayList<>();
        carList.forEach(this::add);
    }

    private void add(Car car) {
        validateDuplicate(car);
        this.cars.add(car);
    }

    private void validateDuplicate(Car car) {
        if (this.cars.contains(car)) {
            throw new IllegalArgumentException("중복된 자동차가 존재합니다.");
        }
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }

    public Car getCar(String name) {
        return cars.stream()
            .filter(car -> car.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 이름의 자동차가 존재하지 않습니다."));
    }
}
