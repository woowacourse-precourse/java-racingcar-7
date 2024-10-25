package racingcar.controller;

import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

public class RacingGameController {
    private final RacingGameInputView racingGameInputView = new RacingGameInputView();
    private final RacingGameOutputView racingGameOutputView = new RacingGameOutputView();
    public void startGame(){
        racingGameOutputView.printRacingGameStartingMessage();
        racingGameInputView.getCarNames();
    }
}
