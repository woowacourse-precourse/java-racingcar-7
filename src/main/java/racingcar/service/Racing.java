package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.strategy.ModeType;
import racingcar.util.CarNameSeparator;
import racingcar.util.CarsCreator;
import racingcar.util.RacingResultCalculator;

public class Racing {
    private final List<Car> racingCars;

    public Racing(String carNames) {
        //검증 로직
        this.racingCars = createCar(carNames);
    }

    private List<Car> createCar(String carNames) {
        List<String> carNamesList = CarNameSeparator.splitCarNameWithSeparator(carNames);
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
