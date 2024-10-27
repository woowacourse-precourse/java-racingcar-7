package racingcar.race.track;

import racingcar.race.racer.car.Car;

public class MockCar extends Car {
    public String distance = "";

    public MockCar(String name, String distance) {
        super(name);
        this.distance = distance;
    }

    @Override
    public String getDistance() {
        return distance;
    }
}
