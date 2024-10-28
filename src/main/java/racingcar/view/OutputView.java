package racingcar.view;

import static racingcar.constant.ViewConstants.RESULT_HEADER;

import racingcar.constant.ViewConstants;
import racingcar.domain.game.GameResult;
import racingcar.dto.response.Winners;

public class OutputView {
    public void displayRunResultText() {
        System.out.println(RESULT_HEADER);
    }

    public void displayResult(GameResult result) {
        result.results().forEach(this::displayStatus);
        System.out.println();
    }

    private void displayStatus(GameResult.PlayerResult result) {
        String position = ViewConstants.FORWARD_SYMBOL.repeat(result.position());
        System.out.printf(ViewConstants.POSITION_FORMAT,
                result.name(), position);
    }

    public void displayWinners(Winners winners) {
        System.out.printf(ViewConstants.WINNERS_FORMAT,
                winners.getNames());
    }
}