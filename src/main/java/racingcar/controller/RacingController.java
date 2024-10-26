package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.Racing;
import racingcar.strategy.ModeType;
import racingcar.util.CarNameSeparator;
import racingcar.util.CarsCreator;
import racingcar.util.RacingResultCalculator;

public class RacingController {
    private final List<Car> cars;
    private Racing racing;

    public RacingController(String carNames) {
        this.cars = createCar(carNames);
    }

    public List<Car> createCar(String carNames) {
        List<String> carNamesList = CarNameSeparator.splitCarNameWithSeparator(carNames);
        return CarsCreator.createCarNameToCar(carNamesList);
    }

    public void setCarMode(ModeType modeType) {
        cars.forEach(car -> car.setMode(ModeType.createCarMode(modeType)));
    }

    public void createRacing(String totalRound) {
        racing = new Racing(totalRound, cars);
    }

    public void startRacing() {
        racing.startRacing();
    }

    public List<String> endRacing() {
        List<Car> racingRecord = racing.getRacingCars();
        Integer racingWinnerRecord = RacingResultCalculator.getCarRacingWinnerRecord(racingRecord);
        return RacingResultCalculator.getCarRacingWinner(racingRecord, racingWinnerRecord);
    }
}
