package controller;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import service.RacingcarService;
import validators.CarValidator;
import validators.RoundValidator;
import view.InputView;
import view.OutputView;

public class RacingcarController {

    private final OutputView outputView;
    private final InputView inputView;
    private final RacingcarService service;

    public RacingcarController(InputView inputView, OutputView outputView, RacingcarService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void start() {
        String carName = inputView.getInputCarName();
        Set<String> uniqueNames = new HashSet<>();
        service.getCars(carName);
        CarValidator.validateCarName(carName,uniqueNames);
        int rounds = inputView.getRounds();
        RoundValidator.countValidate(Collections.singletonList(rounds));
        String roundResults = service.playRounds(rounds);
        outputView.gameResultMessage(roundResults);
        outputView.gameWinnerMessage();
    }
}
