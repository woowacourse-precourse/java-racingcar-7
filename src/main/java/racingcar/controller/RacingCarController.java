package racingcar.controller;

import java.util.Set;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.racingCarService = racingCarService;
    }

    public void initializeGame() {
        Set<String> carNames = splitCarNames();
        int attemptCount = parseAttemptCount();
        startGame(carNames, attemptCount);
    }

    public Set<String> splitCarNames() {
        String carNameList = inputView.getCarName();
        return racingCarService.splitCarName(carNameList);
    }

    public int parseAttemptCount() {
        String attemptCount = inputView.getAttemptCount();
        return racingCarService.parseAttemptCount(attemptCount);
    }

    public void startGame(Set<String> carNames, int attemptCount){

    }

}
