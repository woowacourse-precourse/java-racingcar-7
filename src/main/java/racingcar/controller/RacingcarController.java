package racingcar.controller;

import java.util.List;
import racingcar.model.domain.GameEnvironment;
import racingcar.model.dto.RoundResult;
import racingcar.model.dto.Winners;
import racingcar.model.service.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingcarService racingcarService;

    public RacingcarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingcarService = new RacingcarService(new GameEnvironment());
    }

    public String getCarNames() {
        inputView.printGetCarNamesMessage();
        String carNamesInput = inputView.getInput();

        racingcarService.saveCars(carNamesInput);

        return "success";
    }

    public String getAttemptCount() {
        inputView.printGetAttemptCountMessage();
        String attemptCountInput = inputView.getInput();
        inputView.closeConsole();

        racingcarService.saveAttemptCount(attemptCountInput);

        return "success";
    }

    public String proceedRacingGame() {
        List<RoundResult> results = racingcarService.proceedRacingGame();

        outputView.printProceedGameMessage();
        results.forEach(gameResult -> outputView.collectRoundResult(gameResult.result()));
        outputView.printRoundResult();

        return "success";
    }

    public String getWinners() {
        Winners winner = racingcarService.determineWinners();

        outputView.printWinners(winner);

        return "success";
    }
}
