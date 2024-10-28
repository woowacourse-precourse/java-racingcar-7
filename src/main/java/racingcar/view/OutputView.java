package racingcar.view;

import racingcar.dto.response.GameResult;
import racingcar.dto.response.Winners;

public interface OutputView {
    void displayRunResultText();

    void displayResult(GameResult result);

    void displayWinners(Winners winners);
}
