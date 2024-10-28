package racingcar;

import racingcar.controller.CarNamesController;
import racingcar.controller.NumberController;
import racingcar.controller.RacingController;
import racingcar.controller.WordsController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        String words = InputView.inputWords();

        if (!WordsController.isValid(words) | !WordsController.moreThanOne(words)) {
            throw new IllegalArgumentException();
        }

        List<String> carNames = List.of(words.split(","));

        if (!CarNamesController.isValid(carNames) | !CarNamesController.checkConditions(carNames)) {
            throw new IllegalArgumentException();
        }

        HashMap<String, Integer> carPositions = new HashMap<>();

        for (String carName : carNames) {
            if (CarNamesController.checkDuplication(carName, carPositions)) {
                throw new IllegalArgumentException();
            } else {
                carPositions.put(carName, 0);
            }
        }

        String number = InputView.inputTryNumbers();

        if (!NumberController.isInteger(number) | !NumberController.isNaturalNumber(number)) {
            throw new IllegalArgumentException();
        }

        int tryNumber = Integer.parseInt(number);

        for (int round = 0; round < tryNumber; round++) {
            RacingController.racing(carNames, carPositions);
            OutputView.progressResults(round, carNames, carPositions);
        }

        List<String> winners = RacingController.findWinners(carNames, carPositions);

        OutputView.finalResult(winners);
    }
}