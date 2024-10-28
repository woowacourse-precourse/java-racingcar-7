package racingcar.interfaces.car;

import racingcar.domain.car.Car;

public record CarResponse(
        String carStatus
) {
    private final static String CAR_POSITION_INDEX = "-";
    private final static String CAR_NAME_AND_POSITION_SEPARATOR = " : ";

    public static CarResponse from(Car car) {
        String carPosition = CAR_POSITION_INDEX.repeat(car.getCarPosition());
        return new CarResponse(car.getCarName() + CAR_NAME_AND_POSITION_SEPARATOR + carPosition);
    }
}
