package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.service.RacingGameService;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarNameValidator carNameValidator;
    private final TryCountValidator tryCountValidator;
    private RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carNameValidator = new CarNameValidator();
        this.tryCountValidator = new TryCountValidator();
    }

    public void run() {
        List<String> carNames = getCarNames();
        int tryCount = getTryCount();

        inputView.close(); // Console 자원 해제

        initializeGame(carNames);
        runAllRaces(tryCount);
        printFinalWinners();
    }

    private List<String> getCarNames() {
        String carNamesInput = inputView.inputCarNames();
        carNameValidator.validate(carNamesInput);
        return Stream.of(carNamesInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private int getTryCount() {
        String tryCountInput = inputView.inputTryCount();
        tryCountValidator.validate(tryCountInput);
        return Integer.parseInt(tryCountInput);
    }

    private void initializeGame(List<String> carNames) {
        racingGameService = new RacingGameService(carNames, outputView);
        outputView.printResultHeader();
    }

    private void runAllRaces(int tryCount) {
        racingGameService.startRace(tryCount);
    }

    private void printFinalWinners() {
        outputView.printWinners(racingGameService.findWinners());
    }

}
