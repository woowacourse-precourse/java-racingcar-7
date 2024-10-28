package racingcar.controller;

import racingcar.model.RacingCarRepository;
import racingcar.validator.Validator;
import racingcar.view.RacingCarIO;

import java.util.ArrayList;

public class RacingCarController {
    private final RacingCarIO racingCarIO;
    private final RacingCarRepository racingCarRepository;
    private final Validator validator;

    public RacingCarController(RacingCarIO racingCarIO, RacingCarRepository racingCarRepository, Validator validator) {
        this.racingCarIO = racingCarIO;
        this.racingCarRepository = racingCarRepository;
        this.validator = validator;
    }

    public void getCarList() {
        String carInfo = racingCarIO.getCarInfo();

        ArrayList<String> cars = validator.splitByComma(carInfo);
        ArrayList<String> refinedCars = validator.changeSameName(cars);

        for (String car : refinedCars) {
            racingCarRepository.addCar(car);
        }
    }

    public void getTryCount() {
        String tryCountStr = racingCarIO.tryCountInfo();

        Long tryCount = validator.convertTryCount(tryCountStr);

        racingCarRepository.setTryCount(tryCount);
    }
}
