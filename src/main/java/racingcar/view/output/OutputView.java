package racingcar.view.output;

import racingcar.GameResult;

public class OutputView {

    private final OutputPrinter outputPrinter = new OutputPrinter();

    public void printResult(GameResult gameResult) {
        outputPrinter.printResult(gameResult);
    }
}
