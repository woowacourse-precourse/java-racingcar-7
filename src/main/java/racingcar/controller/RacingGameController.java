package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.model.RacingGame;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }

    public void run() {
        // 초기화 단계: 사용자 입력을 통해 경주 초기화
        List<String> carNames = inputView.getCarNames();
        int attempts = inputView.getAttempts();
        RacingGame racingGame = racingGameService.initializeRace(carNames, attempts);

        // 경주 진행 및 결과 출력
        outputView.printRaceResultPrefix();
        List<Map<String, Integer>> raceHistory = racingGameService.runRace(racingGame);

        // 라운드별 결과 출력
        raceHistory.forEach(outputView::printRaceProcess);

        // 최종 우승자 출력
        List<String> winners = racingGameService.getWinners(racingGame.cars());
        outputView.printWinners(winners);
    }
}
