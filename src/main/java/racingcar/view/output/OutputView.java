package racingcar.view.output;

import java.util.List;

public interface OutputView {
    void printRoundResult(List<RoundView> results);

    void printGameResult(List<String> winners);
}
