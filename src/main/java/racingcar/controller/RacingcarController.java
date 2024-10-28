package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.NotNumberAttemptException;
import racingcar.service.RacingcarService;
import racingcar.validator.RoundValidator;
import racingcar.view.View;

public class RacingcarController {
    private final RacingcarService racingcarService;
    private final View view;

    public RacingcarController(View view, RacingcarService racingcarService) {
        this.view = view;
        this.racingcarService = racingcarService;
    }

    public void run() {
        var players = view.playerInput();
        racingcarService.initializeCars(players);
        var attempts = getRound();

        List<String> roundResult = new ArrayList<>();
        for (int i = 0; i < attempts; i++) {
            racingcarService.moveCars();
            String roundStatus = racingcarService.getRoundStatus();
            roundResult.add(roundStatus);
        }
        view.displayRoundStatus(roundResult);

        List<String> result = racingcarService.findWinners();
        view.outputResult(result);
    }


    private int getRound() {
        var input = view.roundInput();
        int round;
        try {
            round = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotNumberAttemptException();
        }
        RoundValidator.validate(round);

        return round;
    }

}
