package racingcar.controller;

import static racingcar.view.OutputView.*;
import static racingcar.view.RaceMessage.*;
import static racingcar.view.InputView.*;

import racingcar.domain.Race;
import racingcar.validation.InputValidator;

public class RacingController {
    private final Race race;

    public RacingController(Race race) {
        this.race = race;
    }

    public void run() {
        setRace();
        startRace();
        raceFinished();
    }

    private void setRace() {
        InputValidator inputValidator = new InputValidator();
        String carName = requestInput(CAR_NAME_INPUT.getMessage());
        race.setCars(carName);

        String roundsInput = requestInput(NUMBER_OF_RACE_INPUT.getMessage());
        race.setRounds(inputValidator.validateRounds(roundsInput));
    }

    private void startRace() {
        newLinePrint(PRINT_RACE_RESULT.getMessage());

        int rounds = race.getRounds();
        while (rounds-- > 0) {
            race.moveCars();
            newLinePrint(race.getRaceResult());
        }
    }

    private void raceFinished() {
        printWinners(PRINT_WINNER_FORMAT.getMessage(), race.getRaceWinner());
    }
}
