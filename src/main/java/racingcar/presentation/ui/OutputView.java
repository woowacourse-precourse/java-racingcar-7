package racingcar.presentation.ui;

import racingcar.application.service.history.RacingHistoryService;
import racingcar.application.service.winner.WinnerService;
import racingcar.presentation.enums.UiMessage;

public class OutputView {
    private final RacingHistoryService racingHistoryService;
    private final WinnerService winnerService;

    public OutputView() {
        this.racingHistoryService = new RacingHistoryService();
        this.winnerService = new WinnerService();
    }

    public void outputRacingResultUi() {
        System.out.println(UiMessage.UI_OUTPUT_EXECUTION_RESULT_MESSAGE.getMessage());
        racingHistoryService.printRacingResult();
    }

    public void outputWinnerUi() {
        System.out.println(UiMessage.UI_OUTPUT_WINNER_RESULT_MESSAGE.getMessage() + winnerService.getWinnerToString());

    }
}
