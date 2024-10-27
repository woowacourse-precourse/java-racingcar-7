package racingcar.controller;

import static racingcar.constant.Constant.*;

import java.math.BigInteger;
import java.util.List;
import racingcar.model.Parser;
import racingcar.model.domain.Cars;
import racingcar.view.OutputView;

public class RaceController {

    private final OutputView outputView;
    private final Parser parser;

    public RaceController(OutputView outputView, Parser parser) {
        this.outputView = outputView;
        this.parser = parser;
    }

    public void runRace(Cars cars, BigInteger attemptCount) {
        outputView.printStartMessage();
        executeRaceRounds(attemptCount, cars);
        displayWinners(cars);
    }

    private void executeRaceRounds(BigInteger attemptCount, Cars cars) {
        BigInteger round = BigInteger.ZERO;

        while (round.compareTo(attemptCount) < 0) {
            cars.raceOnce();
            outputView.printRaceProgress(cars);
            round = round.add(BigInteger.ONE);
        }
    }

    private void displayWinners(Cars cars) {
        List<String> winners = cars.determineWinners();
        String joinedWinnerNames = parser.joinWithJoiner(winners, WINNER_NAME_JOINER);
        outputView.printWinners(joinedWinnerNames);
    }
}
