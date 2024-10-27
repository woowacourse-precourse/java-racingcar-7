package racingcar;

import static racingcar.RandomNumberGenerator.generateRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    private ReadUserInputView inputView;
    private PrintOutputView outputView;

    public RacingGameController(ReadUserInputView inputView, PrintOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.printRequireNames();
        var racingCarNames = inputView.readRacingCarNames();
        outputView.printRequireTryCount();
        var tryCount = inputView.readTryCount();
        var racingCars = new RacingCars(racingCarNames);
        int length = racingCarNames.length;
        outputView.printExecuteStart();

        startRacingCarTry(tryCount, length, racingCars);
        printRacingGameResult(racingCars.calculateGameResult());
    }

    private void startRacingCarTry(long tryCount, int length, RacingCars racingCars) {
        for (long i = 0L; i < tryCount; i++) {
            tryForward(length, racingCars);
            printTryResult(racingCars);
        }
    }

    private void tryForward(int length, RacingCars racingCars) {
        List<Integer> racingCarRandomNumbers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            racingCarRandomNumbers.add(generateRandomNumber());
        }
        racingCars.moveRacingCars(racingCarRandomNumbers);
    }

    private void printTryResult(RacingCars racingCars) {
        outputView.printExecuteResult(racingCars.receiveRacingCarTryResult());
    }

    private void printRacingGameResult(String racingGameWinners) {
        outputView.printWinner(racingGameWinners);
    }
}
