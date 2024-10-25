package racingcar.controller;

import racingcar.dto.ViewDto;
import racingcar.view.RacingGameView;

public class CarRaceController {

    private final RacingGameView view;

    public CarRaceController() {
        this.view = new RacingGameView();
    }

    public void process(){
        ViewDto viewDto = view.startGame();
    }
}
