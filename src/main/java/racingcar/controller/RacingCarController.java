package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.enums.Delimiter;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();

    public void play() {
        Race race = new Race(prepareCars());
        int rounds = inputRounds();
        startRace(race, rounds);
        printWinners(race);
    }

    private List<Car> prepareCars() {
        String inputString = inputView.promptCarNames();
        return racingCarService.makeCarList(inputString);
    }

    private int inputRounds() {
        return Integer.parseInt(inputView.promptRounds());
    }

    private void startRace(Race race, int rounds) {
        outputView.printResult();
        while (rounds-- > 0) {
            runAndPrintRoundStatus(race);
        }
    }

    private void runAndPrintRoundStatus(Race race) {
        race.runRace();
        outputView.printRoundStatus(race);
    }

    private void printWinners(Race race) {
        List<String> winners = race.findWinners();
        String result = String.join(Delimiter.COMMA_WITH_SPACE.getSymbol(), winners);
        outputView.printWinners(result);
    }
}
