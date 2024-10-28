package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private final List<RacingCar> cars;

    public RacingCarList() {
        this.cars = new ArrayList<>();
    }

    public RacingCarList(List<RacingCar> cars) {
        this.cars = cars;
    }

    public void addCar(RacingCar car) {
        cars.add(car);
    }

    public void moveAll() {
        cars.forEach(RacingCar::move);
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public List<RacingCar> getCarsCopy() {
        return new ArrayList<>(cars);// 방어적 복사
    }

    public int getMaxDistance() {
        return cars.stream()
                .mapToInt(RacingCar::getDistance)
                .max()
                .orElse(0);
    }

    public int size() {
        return cars.size();
    }

}
