package racingcar.service;

import java.util.List;
import racingcar.exception.RacingException;
import racingcar.model.Car;
import racingcar.strategy.ModeType;
import racingcar.util.CarNameSeparator;
import racingcar.util.CarsCreator;
import racingcar.util.RacingResultCalculator;

public class Racing {
    private final List<Car> racingCars;

    public Racing(String carNames) {
        RacingException.separatorException(carNames);
        List<String> carNameList = CarNameSeparator.splitCarNameWithoutSpace(carNames);
        RacingException.emptyException(carNameList);
        RacingException.duplicationException(carNameList);
        this.racingCars = createCar(carNameList);
    }

    private List<Car> createCar(List<String> carNamesList) {
        return CarsCreator.createCarNameToCar(carNamesList);
    }

    public void tryMovingCars() {
        racingCars.forEach(Car::tryMoving);
    }

    public void setRacingCarMode(ModeType modeType) {
        racingCars.forEach(car -> car.setMode(ModeType.createCarMode(modeType)));
    }

    public List<String> getRacingWinner() {
        Integer racingWinnerRecord = RacingResultCalculator.calculateCarRacingWinnerRecord(racingCars);
        return RacingResultCalculator.calculateCarRacingWinner(racingCars, racingWinnerRecord);
    }
}
