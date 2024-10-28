package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.domain.Movement;
import racingcar.domain.TrialCoin;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final OutputView outputView;
    private final Movement movement;
    private final Cars cars;
    private final TrialCoin trialCoin;

    public RacingController(InputView inputView, OutputView outputView, Movement movement) {
        String[] names = inputView.readNames();
        cars = Cars.ofNames(getTrimmedStrings(names));
        trialCoin = new TrialCoin(inputView.putCoins());
        this.outputView = outputView;
        this.movement = movement;
    }

    public void run() {
        outputView.printBeforeResult();
        while (trialCoin.isCoinLeft()) {
            cars.move(movement);
            outputView.printProgress(cars.getCarsInfo());
            trialCoin.decrease();
        }
        outputView.printWinners(cars.findWinners());
    }

    private List<String> getTrimmedStrings(String[] names) {
        return Arrays.stream(names)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
