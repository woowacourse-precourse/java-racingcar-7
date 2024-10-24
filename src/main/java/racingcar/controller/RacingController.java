package racingcar.controller;

import static racingcar.view.RaceMessage.*;
import static racingcar.view.InputView.*;

import racingcar.domain.Car;
import racingcar.domain.Race;

public class RacingController {
    private final Car car;
    private final Race race;

    RacingController(Car car, Race race) {
        this.car = car;
        this.race = race;
    }

    private void setRace() {
        String carName = printInputMessage(CAR_NAME_INPUT.getMessage());
        race.setCars(carName);

        try {
            race.setRounds(Integer.parseInt(printInputMessage(NUMBER_OF_RACE_INPUT.getMessage())));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

}
