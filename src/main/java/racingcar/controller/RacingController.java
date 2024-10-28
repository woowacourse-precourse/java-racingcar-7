package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
        String[] names = inputView.readNames();
        cars = Cars.ofNames(getTrimmedNames(names));
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

    private List<String> getTrimmedNames(String[] names) {
        return Arrays.stream(names)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
