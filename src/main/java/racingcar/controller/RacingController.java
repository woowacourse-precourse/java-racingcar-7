package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingController {
    public void run() {
        OutputView.printInputCarNameMessage();
        String input = InputView.inputCarNames();
        String trimmedInput = InputView.removeSpace(input);
        List<String> carNames = InputView.splitStringByDelimiters(trimmedInput, ",");
        int totalCarCounts = carNames.size();

        OutputView.printInputAttemptCountMessage();
        int attemptCount = InputView.inputAttemptCount();

        OutputView.printExecutionResultMessage();

        List<Integer> moveCounts = new ArrayList<>(Collections.nCopies(totalCarCounts, 0));
        while (attemptCount-- > 0) {
            RacingService.moveOrStop(moveCounts);
            OutputView.printEachStepResult(carNames, moveCounts, totalCarCounts);
        }

        List<String> winnerNames = RacingService.getWinners(moveCounts, carNames);
        if(winnerNames.size() == 1) OutputView.printSoloWinnerMessage(winnerNames.get(0));
        if(winnerNames.size() != 1) OutputView.printJointWinnerMessage(winnerNames);


    }
}
