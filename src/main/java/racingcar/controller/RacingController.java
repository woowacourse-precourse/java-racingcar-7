package racingcar.controller;

import static racingcar.view.OutputView.*;
import static racingcar.view.RaceMessage.*;
import static racingcar.view.InputView.*;

import racingcar.domain.Race;

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
        String carName = printInputMessage(CAR_NAME_INPUT.getMessage());
        race.setCars(carName);

        try {
            race.setRounds(Integer.parseInt(printInputMessage(NUMBER_OF_RACE_INPUT.getMessage())));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("2,147,483,647 이하의 양수를 입력해주세요.");
        }
    }

    private void startRace() {
        printMessage(PRINT_RACE_RESULT.getMessage());

        int rounds = race.getRounds();
        while (rounds-- > 0) {
            race.moveCars();
            printMessage(race.getRaceResult() + "\n");
        }
    }

    private void raceFinished() {
        printWinners(PRINT_WINNER_FORMAT.getMessage(), race.getRaceWinner());
    }
}
