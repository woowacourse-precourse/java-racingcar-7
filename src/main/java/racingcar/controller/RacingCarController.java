package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.Map;
import java.util.List;

public class RacingCarController {
    private final RacingCarService service;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(RacingCarService service, InputView inputView, OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String carNames = inputView.getCarsName();
        String numberOfRoundsStr = inputView.getNumber();
        int numberOfRounds = Integer.parseInt(numberOfRoundsStr);

        Map<String, Integer> raceStatus = service.initializeCars(carNames);

        // 각 라운드 진행
        for (int i = 0; i < numberOfRounds; i++) {
            service.progressRound(raceStatus);
            OutputView.printProgress(raceStatus); // 현재 진행 상황 출력
        }

        // 최종 결과 출력
        List<String> winners = service.getWinners(raceStatus);
        outputView.printResult(winners);
    }
}
