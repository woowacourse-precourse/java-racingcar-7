package racingcar.controller;

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

    }


    private int getRound() {
        var input = view.roundInput();
        int round;
        try {
            round = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("자연수가 아닌 값이 들어왔습니다.");
        }
        RoundValidator.validate(round);

        return round;
    }

}
