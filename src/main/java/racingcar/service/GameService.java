package racingcar.service;

import racingcar.domain.Cars;
import racingcar.dto.response.CarsResponse;

public class GameService {

    public CarsResponse moveCars(Cars cars) {
        cars.move();
        return CarsResponse.from(cars);
    }
}
