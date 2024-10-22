package racingcar.controller;

import racingcar.view.InputView;

public class RacingcarController {

    public void run(){
        beforeRacingGame();

    }

    private void beforeRacingGame(){
        InputView.printInputRacingcarsMessage();
    }


}
