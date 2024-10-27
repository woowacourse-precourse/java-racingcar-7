package racingcar.controller;

import racingcar.util.CommonIo;
import racingcar.util.ErrorMessage;
import racingcar.util.Limit;
import racingcar.view.InputView;

public class PlayCountController {
    private final InputView inputView;
    private final CommonIo io;

    public PlayCountController() {
        this.inputView = new InputView();
        this.io = new CommonIo();
    }

    public int validatePlayCount() {
        String playCountInput = inputView.receivePlayCount();
        int playCount = convertPlayCount(playCountInput);
        checkPlayCountLimit(playCount);

        return playCount;
    }

    private int convertPlayCount(String playCountInput) {
        try {
            return io.convertStringToInt(playCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PLAY_COUNT_FORMAT.getError());
        }
    }

    private void checkPlayCountLimit(int playCount) {
        if (playCount < Limit.MIN_PLAY.getValue() || playCount > Limit.MAX_PLAY.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.PLAY_COUNT_LIMIT.getError());
        }
    }

}
