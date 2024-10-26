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
        //검증 로직
        if (CarValidation.validateCarNameSeparator(carNames)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 쉼표(,)로 구분되어야 합니다.");
        }
        // - 자동차 이름 구분자가 쉼표가 아닌 경우 -> 쉼표 포함 여부 판별
        // - 자동차 이름이 중복할 경우 -> set.size != list.size
        // - 자동차가 하나일 경우 -> list.size == 1
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
