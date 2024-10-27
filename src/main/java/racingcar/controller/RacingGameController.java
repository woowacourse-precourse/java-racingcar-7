package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.utils.CarNameInputProcessor;
import racingcar.utils.MoveInputProcessor;
import racingcar.view.InputView;

public class RacingGameController {
    public void run(){
        List<String> carNames = setCarNames();
        int moveCount = setMoveCount();
        RacingGame racingGame = new RacingGame(moveCount, carNames);
    }

    private List<String> setCarNames(){
        String carNames = InputView.getCarNames();
        CarNameInputProcessor carNameInputProcessor = new CarNameInputProcessor(carNames);
        return carNameInputProcessor.splitCarNames();
    }

    private int setMoveCount(){
        String moveCount = InputView.getMoveCount();
        MoveInputProcessor moveInputProcessor = new MoveInputProcessor(moveCount);
        return moveInputProcessor.getMoveCount();
    }
}
