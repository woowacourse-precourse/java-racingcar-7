package racingcar.view.output;

import java.util.List;

public interface OutputView {
    void printGameStart();
    void printRoundResult(List<String> results);
    void printWinners(List<String> winners);
    void printError(String message);
}