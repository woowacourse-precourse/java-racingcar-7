package racingcar.model;

import racingcar.model.car.Car;

public record CarSnapshot(String carName, int position) {
    public CarSnapshot(Car car) {
        this(car.getCarName(), car.getPosition());
    }
}
