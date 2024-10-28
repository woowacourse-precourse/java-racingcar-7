package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.race.Race;
import racingcar.domain.race.RandomNumberGenerator;
import racingcar.domain.race.dto.RaceResultDto;
import racingcar.domain.race.dto.WinnersDto;
import racingcar.view.View;

public class RacingController {
    private final View view;

    public RacingController() {
        this.view = View.create();
    }

    public void start() {
        Cars cars = createCarsFromUserInput();
        Race race = createRaceFromUserInput();
        racing(cars, race);
    }

    private Cars createCarsFromUserInput() {
        String carNames = view.inputCarNames();
        return Cars.from(carNames);
    }

    private Race createRaceFromUserInput() {
        String raceCount = view.inputRaceCount();
        return Race.of(raceCount, RandomNumberGenerator.create());
    }

    private void racing(Cars cars, Race race) {
        RaceResultDto raceResult = race.progress(cars);
        WinnersDto winners = race.getWinners(cars);
        view.outputRaceResultAndWinners(raceResult, winners);
    }
}
