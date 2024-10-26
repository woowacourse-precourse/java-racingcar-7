package custom.controller;

import custom.model.RacingScoreBoard;
import custom.service.CarNameParser;
import custom.service.GetAttemptCount;
import custom.service.RaceExecutor;
import custom.view.InputView;
import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final RacingScoreBoard racingScoreBoard;
    private final CarNameParser carNameParser;
    private final GetAttemptCount getAttemptCount;
    private final RaceExecutor raceExecutor;

    public RacingCarController() {
        this.inputView = new InputView();
        this.racingScoreBoard = new RacingScoreBoard();
        this.carNameParser = new CarNameParser();
        this.getAttemptCount = new GetAttemptCount();
        this.raceExecutor = new RaceExecutor();
    }

    public void run() {
        String carNamesInput = inputView.displayCarNamePrompt();
        List<String> carList = carNameParser.run(carNamesInput);

        String attemptCountInput = inputView.displayCountPrompt();
        int attemptCount = getAttemptCount.run(attemptCountInput);

        racingScoreBoard.registerCars(carList);

        for (int round = 1; round <= attemptCount; round++) {
            raceExecutor.run();
            // 시도 횟수별 출력 코드 추가
        }
        // 우승자 출력 코드 추가
    }
}