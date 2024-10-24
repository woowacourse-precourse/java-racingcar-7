package racingcar.controller;

import racingcar.model.RacingGameModel;
import racingcar.view.RacingGameView;

public class RacingGameControllerImpl implements RacingGameController{

    private final RacingGameModel model;
    private final RacingGameView view;

    public RacingGameControllerImpl(RacingGameModel model, RacingGameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void run() {
        String carNames = view.getCarNames();
        String trialNum = view.getTrialNum();

        String result = model.play(carNames, trialNum);

        view.showResult(result);
    }
}