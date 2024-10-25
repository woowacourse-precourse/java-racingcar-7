package racingcar.controller;

import java.util.List;
import racingcar.service.RacingGameService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = new InputValidator();
    }

    public void run() {
        // 1. 자동차 이름 입력
        String carNamesInput = inputView.inputCarNames();
        List<String> carNames = inputValidator.validateAndParseCarNames(carNamesInput);

        // 2. 시도 횟수 입력
        String tryCountInput = inputView.inputTryCount();
        int tryCount = inputValidator.validateAndParseTryCount(tryCountInput);

        // 3. 게임 초기화 및 실행
        initializeGame(carNames);
        runAllRaces(tryCount);
        printFinalWinners();
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
