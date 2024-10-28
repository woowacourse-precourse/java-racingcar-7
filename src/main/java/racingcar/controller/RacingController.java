package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.util.InputSplitter;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private final RacingCars racingCars;

    public RacingController() {
        this.racingCars = new RacingCars();
    }

    public void startGame() {
        registerRacingCars();
        int round = getRoundNumber();

        OutputView.printExecutionResultMessage();
        for (int i = 0; i < round; i++) {
            racingCars.updatePositionsWithRandomNumbers(generateRandomNumbers(countCars()));
            OutputView.printRoundResult(racingCars.getStatus());
        }
        OutputView.printWinnerNames(racingCars.selectWinners());
    }

    private void registerRacingCars() {
        OutputView.printInputCarNameMessage();
        List<String> carNames = InputSplitter.splitByComma(InputView.inputCarNames());
        racingCars.registerCars(carNames);
    }

    private int getRoundNumber() {
        OutputView.printInputRoundMessage();
        String inputRoundNumber = InputView.inputRoundNumber();

        return Integer.parseInt(inputRoundNumber);
    }

    private List<Integer> generateRandomNumbers(int racingCarCount) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < racingCarCount; i++) {
            randomNumbers.add(RandomNumberGenerator.generate());
        }
        return randomNumbers;
    }

    private int countCars() {
        return racingCars.getStatus().size();
    }
}
