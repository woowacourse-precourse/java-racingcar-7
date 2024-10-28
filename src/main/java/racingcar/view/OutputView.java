package racingcar.view;

import racingcar.model.Result;

public interface OutputView {
    void printExecutionMessage();
    void printResult(Result result);
    void printFinalWinner(String finalWinner);
}