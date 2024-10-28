package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Movement;
import racingcar.domain.TrialCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final OutputView outputView;
    private final Movement movement;

    private final Cars cars;
    private final TrialCount trialCount;

    public RacingController(InputView inputView, OutputView outputView, Movement movement) {
        cars = Cars.ofNames(inputView.readNames());
        trialCount = new TrialCount(inputView.inputTrialCounts());
        this.outputView = outputView;
        this.movement = movement;
    }

    public void run() {
        outputView.noticeResult();
        while (trialCount.isCoinLeft()) {
            cars.move(movement);
            outputView.printStatusOf(cars.getCarsInfo());
            trialCount.decrease();
        }
        outputView.printWinners(cars.findWinners());
    }

}
