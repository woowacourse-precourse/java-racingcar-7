package racingcar.controller;

import racingcar.view.RacingGameOutputView;

public class RacingGameController {
    private RacingGameOutputView racingGameOutputView = new RacingGameOutputView();
    public void startGame(){
        racingGameOutputView.printRacingGameStartingMessage();
    }
}
