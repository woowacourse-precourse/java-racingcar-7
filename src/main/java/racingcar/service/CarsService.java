package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.RaceResult;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.dto.WinnerDto;

public class CarsService {

    public Cars createCars(String carNames, MoveStrategy moveStrategy) {
        return new Cars(carNames, moveStrategy);
    }

    public WinnerDto getWinnerNames(Cars cars) {
        RaceResult raceResult = getRaceResult(cars);

        return new WinnerDto(raceResult.getWinners());
    }

    private RaceResult getRaceResult(Cars cars) {
        return new RaceResult(cars);
    }

}
