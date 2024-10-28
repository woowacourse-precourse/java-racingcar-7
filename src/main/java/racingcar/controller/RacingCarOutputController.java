package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.view.ResultView;
import racingcar.view.RoundView;

import java.util.List;
import java.util.stream.IntStream;

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

    public void showRaceRound(List<RacingCar> racingCars) {
        roundView.showRoundResults(racingCars);
    }

    public void printResult(List<RacingCar> bestDriver) {
        resultView.printResult(bestDriver);
    }
}
