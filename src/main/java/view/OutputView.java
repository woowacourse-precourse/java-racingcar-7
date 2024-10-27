package view;

import constant.Comment;
import service.ResultService;

public class OutputView {

    private final ResultService resultService;

    public OutputView(ResultService resultService) {
        this.resultService = resultService;
    }

    public void gameResultMessage(String roundResults) {
        System.out.printf(Comment.RESULT_MESSAGE.getMessage() + roundResults);
    }

    public void gameWinnerMessage() {
        System.out.printf(Comment.WINNER_MESSAGE.getMessage() + resultService.displayWinners());
    }
}

