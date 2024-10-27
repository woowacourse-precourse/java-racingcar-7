package view;

import static constant.Comment.RESULT_MESSAGE;
import static constant.Comment.WINNER_MESSAGE;

import service.ResultService;

public class OutputView {

    private final ResultService resultService;

    public OutputView(ResultService resultService) {
        this.resultService = resultService;
    }

    public void gameResultMessage(String roundResults) {
        System.out.printf(RESULT_MESSAGE.getMessage() + roundResults);
    }

    public void gameWinnerMessage() {
        System.out.printf(WINNER_MESSAGE.getMessage() + resultService.displayWinners());
    }
}

