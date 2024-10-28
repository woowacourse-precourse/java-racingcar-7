package racingcar.controller;

import static racingcar.utils.LoggerUtils.logError;
import static racingcar.utils.LoggerUtils.logInfo;
import racingcar.model.car.RandomMoveStrategy;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final RaceService raceService;

    public GameController(RaceService raceService) {
        this.raceService = raceService;
    }

    public void start() {
        try {
            String[] carNames = InputView.getCarNames();
            int tryCount = InputView.getTryCount();
            initializeRace(carNames, tryCount);
            playRace(tryCount);
            announceWinners();
        } catch (IllegalArgumentException e) {
            logError("입력 오류 발생: " + e.getMessage());
            throw e;
        }
    }

    private void initializeRace(String[] carNames, int tryCount) {
        raceService.initializeRace(carNames, new RandomMoveStrategy(), tryCount);
        logInfo("경주 초기화 완료 - 자동차 이름: " + String.join(", ", carNames) + ", 시도 횟수: " + tryCount);
    }

    private void playRace(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            raceService.moveCars();
            logInfo("경주 진행 중 - 현재 시도 횟수: " + (i + 1));
            OutputView.printResult(raceService.getCars());
        }
    }

    private void announceWinners() {
        OutputView.printWinners(raceService.getWinners());
    }
}
