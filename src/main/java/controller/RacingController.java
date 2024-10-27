package controller;

import java.util.Collections;
import service.CarSetService;
import service.GameService;
import validators.RoundValidator;
import view.InputView;
import view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;
    private final CarSetService carSetService;

    public RacingController(InputView inputView, OutputView outputView, GameService gameService, CarSetService carSetService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
        this.carSetService = carSetService;
    }

    public void start() {
        String carName = inputView.getInputCarName();
        carSetService.getCars(carName);

        String roundsInput = inputView.getRounds();
        RoundValidator.StringValidate(Collections.singletonList(roundsInput));

        int rounds = Integer.parseInt(roundsInput);
        RoundValidator.countValidate(Collections.singletonList(rounds));

        String roundResults = gameService.playRounds(rounds);
        outputView.gameResultMessage(roundResults);
        outputView.gameWinnerMessage();
    }
}
