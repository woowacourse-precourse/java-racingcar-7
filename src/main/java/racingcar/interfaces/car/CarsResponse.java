package racingcar.interfaces.car;

import java.util.List;
import racingcar.domain.car.Cars;

public record CarsResponse(
        List<CarResponse> carResponses
) {
    public static CarsResponse from(Cars cars) {
        return new CarsResponse(cars.getCars().stream()
                .map(CarResponse::from)
                .toList());
    }
}
