package racingcar.service;

import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.RacingGameRound;

import java.util.List;

public class RacingGameService {
    private final CarFactory carFactory = new CarFactory();
    public List<Car> createCars(String carNames){
        return carFactory.createCars(carNames);
    }
}
