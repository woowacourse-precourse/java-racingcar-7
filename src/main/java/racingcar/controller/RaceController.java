package racingcar.controller;

import static racingcar.constant.Constant.*;

import java.math.BigInteger;
import java.util.List;
import racingcar.model.Parser;
import racingcar.model.RaceService;
import racingcar.model.domain.Car;
import racingcar.view.OutputView;

public class RaceController {

    private final OutputView outputView;
    private final Parser parser;
    private final RaceService raceService;

    public RaceController(OutputView outputView, Parser parser, RaceService raceService) {
        this.outputView = outputView;
        this.parser = parser;
        this.raceService = raceService;
    }

    public void runRace(List<String> carNames, BigInteger attemptCount) {
        List<Car> cars = raceService.createCars(carNames);
        executeRaceRounds(attemptCount, cars);
        displayWinners(cars);
    }

    private void executeRaceRounds(BigInteger attemptCount, List<Car> cars) {
        outputView.printStartMessage();
        BigInteger round = BigInteger.ZERO;

        while (round.compareTo(attemptCount) < 0) {
            raceService.raceOnce(cars);
            outputView.printRaceProgress(cars);
            round = round.add(BigInteger.ONE);
        }
    }

    private void displayWinners(List<Car> cars) {
        List<String> winners = raceService.determineWinners(cars);
        String joinedWinnerNames = parser.joinWithJoiner(winners, WINNER_NAME_JOINER);
        outputView.printWinners(joinedWinnerNames);
    }
}
