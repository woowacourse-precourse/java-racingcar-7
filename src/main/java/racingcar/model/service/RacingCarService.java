package racingcar.model.service;

import racingcar.dto.RacingCarRequest;
import racingcar.dto.RacingCarResponse;
import racingcar.model.Racing;
import racingcar.model.car.Car;
import racingcar.model.car.CarFactory;

import java.util.List;

public class RacingCarService {
    private final CarFactory carFactory;

    public RacingCarService(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    public RacingCarResponse startGame(RacingCarRequest racingCarRequest) {
        List<Car> cars = carFactory.produceCars(racingCarRequest.carNames());
        Racing racing = Racing.of(cars, racingCarRequest.moveCount());

        racing.start();
        List<Car> winCars = racing.getWinners();
        return new RacingCarResponse(cars, winCars);
    }

}
