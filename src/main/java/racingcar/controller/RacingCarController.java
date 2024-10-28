package racingcar.controller;

import static racingcar.util.Utility.getSplitCarNames;
import static racingcar.validator.Validator.validateInputCarNamesContainComma;
import static racingcar.validator.Validator.validateInputCountRange;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final OutputView outputView;
    private final RacingCarService service;
    private final InputView inputView;

    public RacingCarController(RacingCarService service, InputView inputView, OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        String inputCarNames = getInputCarNames();
        List<String> splitCarNames = getSplitCarNames(inputCarNames);

        int inputCount = getInputCount();

        Map<String, Integer> cars = service.getNewCars(splitCarNames);
        race(inputCount, cars);
        printWinners(cars);
    }

    private String getInputCarNames() {
        String inputCarNames = inputView.readCarNames();
        validateInputCarNamesContainComma(inputCarNames);
        return inputCarNames;
    }

    private int getInputCount() {
        int inputCount = inputView.readTryCount();
        validateInputCountRange(inputCount);
        return inputCount;
    }

    private void race(int inputCount, Map<String, Integer> cars) {
        IntStream.range(0, inputCount).forEach(count -> {
            service.raceOneRound();
            outputView.printOneRoundResult(cars);
        });
    }

    private void printWinners(Map<String, Integer> cars) {
        service.getMaxPosition(cars);
        Set<String> winningCars = service.getWinningCars(cars);
        outputView.printWinningCars(winningCars);
    }
}
