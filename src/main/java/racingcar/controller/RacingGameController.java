package racingcar.controller;

import java.util.List;
import racingcar.service.RacingGameService;
import racingcar.utils.CarNameParser;
import racingcar.utils.TryCountParser;
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

    public RacingGameController(InputView inputView, OutputView outputView,
                                CarNameValidator carNameValidator,
                                TryCountValidator tryCountValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carNameValidator = carNameValidator;
        this.tryCountValidator = tryCountValidator;
    }

    public void run() {
        List<String> carNames = getCarNames();
        int tryCount = getTryCount();

        initializeGame(carNames);
        runAllRaces(tryCount);
        printFinalWinners();

        closeInput(); // 입력 스트림 자원 해제
    }

    private List<String> getCarNames() {
        String carNamesInput = inputView.inputCarNames();
        carNameValidator.validate(carNamesInput);
        return CarNameParser.splitCarNames(carNamesInput);
    }

    private int getTryCount() {
        String tryCountInput = inputView.inputTryCount();
        tryCountValidator.validate(tryCountInput);
        return TryCountParser.parseToInt(tryCountInput);
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

    private void closeInput() {
        inputView.close(); // 입력 스트림 자원 해제
    }

}
