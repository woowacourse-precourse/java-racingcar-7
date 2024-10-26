package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.request.CarsRequest;
import racingcar.dto.response.CarsResponse;
import racingcar.dto.response.WinnerResponse;

import java.util.List;

public class GameService {

    private Cars cars;

    public void initializeCars(CarsRequest carsRequest) {
        this.cars = carsRequest.toCars();
    }

    public CarsResponse moveCars() {
        cars.move();
        return CarsResponse.from(cars);
    }

    public WinnerResponse drawWinner() {
        List<Car> winners = cars.drawWinner();
        return WinnerResponse.from(winners);
    }
}
