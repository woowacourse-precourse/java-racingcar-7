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
        String nameInput = inputView.executeNameInput();
        String roundInput = inputView.executeRoundInput();

        List<String> racingCars = inputValidator.isValidCarsName(nameInput);
        Integer round = inputValidator.isValidRound(roundInput);

        gameService.init(round, racingCars);
        play(round);
        List<String> winners = gameService.selectWinner();
        outputView.printWinnerMessage(winners);
    }

    public void play(Integer round) {
        for (int i = 0; i < round; i++) {
            List<RacingCar> result = gameService.executeLogic();
            outputView.resultMessageLoop(result);
        }
    }
}
