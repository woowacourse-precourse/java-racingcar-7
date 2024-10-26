package racingcar;

public class RacingGame {

    public RacingGame() {
    }

    public void start() {
        String carNames = InputView.inputCarNames();
        String moveCount = InputView.inputTryCount();

        InputFilter inputFilter = new InputFilter(carNames, moveCount);

        CarRacer carRacer = new CarRacer(inputFilter.getCarNames());
        carRacer.moveCars(inputFilter.getMoveCount());

        OutputView.printOutput(OutputView.OUTPUT_FILTER, carRacer.getWinners());
    }
}
