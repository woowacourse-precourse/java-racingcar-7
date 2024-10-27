package racingcar.controller;

import racingcar.dto.RacingResult;
import racingcar.service.Race;
import racingcar.util.validator.InputValidator;

public class RacingCarController {
    private final Race race;

    public RacingCarController() {
        this.race = new Race();
    }

    public RacingResult getRacingResult(String carNames, String tryCount) {
        InputValidator.validate(carNames, tryCount);
        return race.start(carNames, tryCount);
    }
}
