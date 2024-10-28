package racingcar.controller;

import java.util.List;
import racingcar.service.AwardService;
import racingcar.service.GameService;
import racingcar.view.Input;
import racingcar.view.Output;

public class CarRacingController {

    private static CarRacingController instance;

    private final Input input;
    private final Output output;
    private final GameService gameService;
    private final AwardService awardService;

    public CarRacingController(Input input, Output output, GameService gameService, AwardService awardService) {
        this.input = input;
        this.output = output;
        this.gameService = gameService;
        this.awardService = awardService;
    }

    public void startCarRacing() {
        List<String> carNames = input.inputCarNames();
        int roundCount = input.inputRoundCount();
        Integer gameId = gameService.startGame(carNames, roundCount);
        awardService.presentAward(gameId);
    }
}
