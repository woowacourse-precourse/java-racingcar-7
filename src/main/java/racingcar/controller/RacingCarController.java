package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Cars;
import racingcar.domain.power.PowerGenerator;
import racingcar.domain.power.RandomPowerGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final PowerGenerator powerGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController() {
        this.powerGenerator = new RandomPowerGenerator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        String inputCarNames = inputView.inputCarNames();

        String inputTryCount = inputView.inputTryCount();

        List<String> names = Arrays.asList(inputCarNames.split(","));
        Cars cars = new Cars(names);

        outputView.printRunResultMessage();
        runRaceRounds(cars, Integer.parseInt(inputTryCount), powerGenerator);
        outputView.printWinningNames(cars.getWinnerNames());
    }

    private void runRaceRounds(Cars cars, int tryCount, PowerGenerator powerGenerator) {
        IntStream.range(0, tryCount).forEach(i -> executeRound(cars, powerGenerator));
    }

    private void executeRound(Cars cars, PowerGenerator powerGenerator) {
        cars.move(powerGenerator);
        outputView.printForwardStatuses(cars.getForwardStatuses() + "\n");
    }

}
