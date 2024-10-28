package racingcar.view;

import racingcar.constant.ViewConstants;
import racingcar.domain.game.GameResult;
import racingcar.dto.response.Winners;

public class ConsoleOutputView implements OutputView {
    public void displayRunResultText() {
        System.out.println(ViewConstants.RESULT_HEADER);
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
        String formattedNames = String.join(
                ViewConstants.WINNERS_DELIMITER,
                winners.getWinnerNames()
        );
        System.out.printf(ViewConstants.WINNERS_FORMAT, formattedNames);
    }
}