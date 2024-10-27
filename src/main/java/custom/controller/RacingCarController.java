package custom.controller;

import custom.model.RacingScoreBoard;
import custom.service.CarNameParser;
import custom.service.GetAttemptCount;
import custom.service.RaceExecutor;
import custom.view.InputView;
import custom.view.OutputView;
import java.util.List;

public class RacingCarController {
    private final RacingScoreBoard racingScoreBoard;
    private final CarNameParser carNameParser;
    private final GetAttemptCount getAttemptCount;
    private final RaceExecutor raceExecutor;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController() {
        this.racingScoreBoard = new RacingScoreBoard(); // racingScoreBoard 인스턴스 생성
        this.carNameParser = new CarNameParser();
        this.getAttemptCount = new GetAttemptCount();
        this.raceExecutor = new RaceExecutor(racingScoreBoard); // racingScoreBoard 인스턴스 주입
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<String> carList;
        int attemptCount;

        try {
            String carNamesInput = inputView.displayCarNamePrompt();
            carList = carNameParser.run(carNamesInput);

            String attemptCountInput = inputView.displayCountPrompt();
            attemptCount = getAttemptCount.run(attemptCountInput);
        } catch (IllegalArgumentException e) {
            outputView.displayError(e.getMessage()); // 예외 메시지 출력
            throw e; // 프로그램 종료
        }

        racingScoreBoard.registerCars(carList);
        outputView.displayRaceResultPrompt();

        for (int round = 1; round <= attemptCount; round++) {
            raceExecutor.run();
            outputView.displayRaceResultsByRound(racingScoreBoard.getAllScores());
        }
        outputView.displayRaceWinners(racingScoreBoard.getWinners());
    }
}