package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.view.ResultView;
import racingcar.view.RoundView;


public class RacingCarOutputController {

    RoundView roundView;
    ResultView resultView;

    public RacingCarOutputController(RoundView roundView, ResultView resultView) {
        this.roundView = roundView;
        this.resultView = resultView;
    }

    public void startRaceRound() {
        roundView.startRaceRound();
    }

    public void showRaceRound(RacingCars racingCars) {
        roundView.showRoundResults(racingCars);
    }

    public void printResult(RacingCars bestDriver) {
        resultView.printResult(bestDriver);
    }
}
