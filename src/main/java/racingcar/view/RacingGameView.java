package racingcar.view;

import racingcar.dto.ViewDto;

public class RacingGameView {

    private final InputView inputView;

    public RacingGameView() {
        this.inputView = new InputView();
    }

    public ViewDto startGame() {
        return ViewDto.of(inputView.readCarNames(), inputView.readTryCount());
    }

}
