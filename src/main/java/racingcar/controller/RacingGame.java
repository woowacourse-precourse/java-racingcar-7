package racingcar.controller;

import racingcar.domain.CarGroup;
import racingcar.view.InputView;

public class RacingGame {

    private final InputView inputView;

    public RacingGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void run(){
        CarGroup carGroup = new CarGroup(inputView.readCars());
        int roundCount = inputView.readRoundCount();
        
    }

}
