package racingcar.domain.round;

import racingcar.domain.car.Car;

public record RoundResult(String carName, int position) {

    public static RoundResult from(Car car) {
        return new RoundResult(car.getName(), car.getPosition());
    }

}
