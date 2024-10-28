package racingcar.controller;

import static racingcar.utils.LoggerUtils.logError;
import static racingcar.utils.LoggerUtils.logInfo;
import static racingcar.utils.LoggerUtils.logDebug;
import racingcar.model.car.strategy.RandomMoveStrategy;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
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

    private void initializeRace(
            String[] carNames,
            int tryCount
    ) {
        raceService.initializeRace(carNames, new RandomMoveStrategy(), tryCount);
        logInfo("경주 초기화 완료 - 자동차 이름: "
                + String.join(", ", carNames)
                + ", 시도 횟수: " + tryCount);
    }

    private void playRace(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            raceService.moveCars();
            logDebug("경주 진행 중 - 현재 시도 횟수: " + (i + 1));
            OutputView.printResult(raceService.getCars());
        }
    }

    private void announceWinners() {
        logInfo("경주 완료: 우승자를 발표합니다.");
        OutputView.printWinners(raceService.getWinners());
    }
}