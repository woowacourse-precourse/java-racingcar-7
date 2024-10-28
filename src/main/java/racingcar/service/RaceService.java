package racingcar.service;

import racingcar.model.Car;
import racingcar.validator.RaceValidator;


public class RaceService {

    private final RaceValidator raceValidator;

    public RaceService() {
        this.raceValidator = new RaceValidator();
    }

    public int findAttemptNum(String inputAttempt) {
        raceValidator.validateAttempt(inputAttempt);
        return Integer.parseInt(inputAttempt);
    }

    public void checkAdvance(Car car) {
        if(car.getRandomNum() >= 4) {
            car.increaseCountAdvance();
        }
    }

}
