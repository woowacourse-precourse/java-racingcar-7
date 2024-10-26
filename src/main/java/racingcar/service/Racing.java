package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.strategy.ModeType;
import racingcar.util.CarNameSeparator;
import racingcar.util.CarsCreator;
import racingcar.util.RacingResultCalculator;
import racingcar.validation.CarValidation;

public class Racing {
    private final List<Car> racingCars;

    public Racing(String carNames) {
        if (CarValidation.validateCarNameSeparator(carNames)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 쉼표(,)로 구분되어야 합니다. 자동차 경주는 두 대 이상 가능합니다.");
        }
        List<String> carNameList = CarNameSeparator.splitCarNameWithoutSpace(carNames);
        if (CarValidation.validateCarNameEmpty(carNameList)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 존재하지 않습니다. 자동차 경주는 두 대 이상 가능합니다.");
        }
        if (CarValidation.validateCarNameDuplication(carNameList)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복되지 않아야 합니다.");
        }
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
