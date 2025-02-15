package racingcar.model;

import racingcar.model.vo.CarName;

public class Car {
    private final CarName carName;
    private int position = 0;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public String getName() {
        return carName.name();
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carName.equals(car.carName);
    }
}
