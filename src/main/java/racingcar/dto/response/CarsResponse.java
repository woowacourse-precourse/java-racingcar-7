package racingcar.dto.response;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public record CarsResponse(
        List<Car> cars
) {
    public static CarsResponse from(Cars cars) {
        return new CarsResponse(cars.getCars());
    }
}
