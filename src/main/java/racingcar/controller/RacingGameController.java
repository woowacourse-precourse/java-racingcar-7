package racingcar.controller;

import java.util.List;
import racingcar.utils.CarNameInputProcessor;
import racingcar.utils.MoveInputProcessor;
import racingcar.view.RacingGameView;

public class RacingGameController {
    public void run(){
        List<String> carNames = setCarNames();
        int moveCount = setMoveCount();
    }

    private List<String> setCarNames(){
        String carNames = RacingGameView.getCarNames();
        CarNameInputProcessor carNameInputProcessor = new CarNameInputProcessor(carNames);
        return carNameInputProcessor.splitCarNames();
    }

    private int setMoveCount(){
        String moveCount = RacingGameView.getMoveCount();
        MoveInputProcessor moveInputProcessor = new MoveInputProcessor(moveCount);
        return moveInputProcessor.getMoveCount();
    }
}
