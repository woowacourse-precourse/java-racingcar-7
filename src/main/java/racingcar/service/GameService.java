package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.response.CarsResponse;
import racingcar.dto.response.WinnerResponse;

import java.util.List;

public class GameService {

    public CarsResponse moveCars(Cars cars) {
        cars.move();
        return CarsResponse.from(cars);
    }

    public WinnerResponse drawWinner(Cars cars) {
        List<Car> winners = cars.drawWinner();
        return WinnerResponse.from(winners);
    }
}
