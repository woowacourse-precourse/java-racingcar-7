package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.CarNameInput;
import racingcar.service.CarRace;
import racingcar.service.CarRaceResult;

import java.util.List;

public class RacingCarGame {

    private static final CarNameInput carNameInput = new CarNameInput();
    private static final CarRace carRace = new CarRace();
    private static final CarRaceResult carRaceResult = new CarRaceResult();

    public void run(){
        List<Car> cars = carNameInput.carNameInput();
        carRace.carRace(cars);
        carRaceResult.carRaceResult(cars);
    }
}
