package racingcar;

import java.util.List;

public class GameController {
    private final GameService gameService;
    private final OutputView outputView;
    private final InputView inputView;
    private final InputValidator inputValidator;

    public GameController(GameService gameService, OutputView outputView, InputView inputView,
                          InputValidator inputValidator) {
        this.gameService = gameService;
        this.outputView = outputView;
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }

    public void run() {
        List<String> racingCars = getValidCars();
        Integer round = getValidRounds();
        startGame(round, racingCars);
    }

    public List<String> getValidCars() {
        String nameInput = inputView.executeNameInput();
        return inputValidator.isValidCarsName(nameInput);
    }

    public Integer getValidRounds() {
        String roundInput = inputView.executeRoundInput();
        return inputValidator.isValidRound(roundInput);
    }

    private void startGame(Integer round, List<String> racingCars) {
        gameService.init(round, racingCars);
        playRounds(round);
        getWinner();
    }

    public void getWinner() {
        List<String> winners = gameService.selectWinner();
        outputView.printWinnerMessage(winners);
    }

    public void playRounds(Integer round) {
        outputView.printResultGuideMessage();
        for (int i = 0; i < round; i++) {
            List<RacingCar> result = gameService.executeLogic();
            outputView.resultMessageLoop(result);
        }
    }
}
