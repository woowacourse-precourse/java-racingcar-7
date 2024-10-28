package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;
import java.util.Map;
import static racingcar.service.RacingCarService.*;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService service;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.service = new RacingCarService();
    }

    public void race() {
        final String carNameString = getInputCarNameString();
        final List<String> carNameList = InputParser.splitCarNameString(carNameString);
        final String roundCountString = getInputRoundCount();
        final int roundCount = InputParser.getIntRoundCount(roundCountString);

        run(carNameList, roundCount);
    }

    private String getInputCarNameString() {
        return inputView.getCarString();
    }

    private String getInputRoundCount() {
        return inputView.getRoundCount();
    }

    public void run(List<String> carNameList, int roundCount) {
        final Map<String, Integer> raceResultList = service.raceAllRound(carNameList, roundCount);
        printRaceResult(raceResultList);
    }

    public void printRaceResult(Map<String, Integer> raceResultList) {
        outputView.printResultMessage();
        final List<String> winnerList = getWinnerList(raceResultList);
        outputView.printWinner(winnerList);
    }
}
