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

        List<Integer> moveCounts = new ArrayList<>(Collections.nCopies(totalCarCounts, 0));
        while (attemptCount-- > 0) {
            RacingService.moveOrStop(moveCounts);
        }


    }
}
