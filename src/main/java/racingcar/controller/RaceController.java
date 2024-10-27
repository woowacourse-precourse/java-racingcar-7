package racingcar.controller;

import java.util.List;
import racingcar.controller.validator.UserInputValidator;
import racingcar.model.GameService;
import racingcar.model.dto.RoundResult;
import racingcar.model.dto.Winners;
import racingcar.model.gameinfo.CarInfo;
import racingcar.model.gameinfo.RoundInfo;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;
    private final UserInputValidator userInputValidator;
    private RoundInfo roundInfo;
    private List<CarInfo> carInfos;

    public RaceController(InputView inputView, OutputView outputView, GameService gameService,
                          UserInputValidator userInputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
        this.userInputValidator = userInputValidator;
    }

    public void playGame() {
        initializeGame();
        outputView.printSeparator();

        while (!gameService.isGameOver(roundInfo)) {
            executeRound();
        }

        announceWinners();
    }

    private void initializeGame() {
        List<String> carNames = getCarNames();
        Integer roundCount = getRoundCount();
        initializeCarInfos(carNames);
        this.roundInfo = new RoundInfo(roundCount);
    }

    private void initializeCarInfos(List<String> carNames) {
        this.carInfos = carNames.stream()
                .map(CarInfo::new)
                .toList();
    }

    private Integer getRoundCount() {
        return userInputValidator.validateRoundCount(inputView.getRoundCount());
    }

    private List<String> getCarNames() {
        return userInputValidator.validateCarNames(inputView.getCarNames());
    }

    private void executeRound() {
        RoundResult roundResult = gameService.executeRound(roundInfo, carInfos);
        outputView.printRoundResult(roundResult);
    }

    private void announceWinners() {
        Winners winners = gameService.findWinners(carInfos);
        outputView.printWinner(winners);
    }
}
