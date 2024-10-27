package racingcar.view;

import java.util.List;

public interface OutputView {
    void printResultMessage();
    void printRoundResult(List<String> roundResult);
    void printWinningCars(List<String> winningCars);
}
