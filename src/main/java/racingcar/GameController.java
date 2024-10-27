package racingcar;

import java.util.List;

public class GameController {
    private final GameService gameService;
    private final OutputView outputView;
    private final InputView inputView;
    private final InputValidator inputValidator;

    public GameController(GameService gameService, OutputView outputView, InputView inputView
    , InputValidator inputValidator) {
        this.gameService = gameService;
        this.outputView = outputView;
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }

    public void run() {
        inputView.printNameMessage();
        String carNames = inputView.input();
        inputView.printNumberMessage();
        String round = inputView.input();

        inputValidator.isValidInputFormat(carNames);
        inputValidator.isValidName(carNames);
        inputValidator.isValidInputFormat(round);

        gameService.init(Parser.toInteger(round), Parser.splitByDelimiter(carNames));
        play(Parser.toInteger(round));

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
