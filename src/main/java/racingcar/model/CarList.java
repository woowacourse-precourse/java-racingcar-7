package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final List<Drivable> cars;

    public CarList() {
        this.cars = new ArrayList<>();
    }

    public CarList(List<Drivable> cars) {
        this.cars = cars;
    }

    public void addCar(Drivable car) {
        cars.add(car);
    }

    public void moveAll() {
        cars.forEach(Drivable::move);
    }

    public List<Drivable> getCars() {
        return cars;
    }

    public List<Drivable> getCarsCopy() {
        return new ArrayList<>(cars);// 방어적 복사
    }

    public int getMaxDistance() {
        return cars.stream().mapToInt(Drivable::getDistance).max().orElse(0);
    }

    public int size() {
        return cars.size();
    }

}
