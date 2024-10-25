package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> drawWinner() {
        int record = getRecord();
        return cars.stream()
                .filter(car -> car.getPosition().getPosition() == record)
                .toList();
    }

    private int getRecord() {
        int record = 0;
        for (Car car : cars) {
            int position = car.getPosition().getPosition();
            if (position > record) {
                record = position;
            }
        }
        return record;
    }

    public List<Car> getCars() {
        return cars;
    }
}
