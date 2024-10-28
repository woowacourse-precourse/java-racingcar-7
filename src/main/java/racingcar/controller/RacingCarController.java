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

        int numberOfRounds;
        try {
            numberOfRounds = Integer.parseInt(numberOfRoundsStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 정수로 입력해야 합니다.");
        }

        Map<String, Integer> raceStatus = service.initializeCars(carNames);

        for (int i = 0; i < numberOfRounds; i++) {
            service.progressRound(raceStatus);
            OutputView.printProgress(raceStatus);
        }

        List<String> winners = service.getWinners(raceStatus);
        outputView.printResult(winners);
    }
}
