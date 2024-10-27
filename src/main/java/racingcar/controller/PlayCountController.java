package racingcar.controller;

import racingcar.util.CommonIo;
import racingcar.util.ErrorMessage;
import racingcar.util.Limit;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class PlayCountController {
    private InputView inputView = new InputView();
    private CommonIo io = new CommonIo();

    public int validatePlayCount(){
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
