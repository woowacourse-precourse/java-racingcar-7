package racingcar.controller;

import racingcar.dto.RacingcarResults;
import racingcar.dto.UserInput;
import racingcar.service.RacingcarService;
import racingcar.view.RacingcarView;

public class SimpleRacingcarPlayer implements RacingcarController {

    private final RacingcarService racingcarService;
    private final RacingcarView racingcarView;

    public SimpleRacingcarPlayer(RacingcarService racingcarService, RacingcarView racingcarView) {
        this.racingcarService = racingcarService;
        this.racingcarView = racingcarView;
    }

    @Override
    public void startRace() {
        UserInput userInput = racingcarView.getInput();

        racingcarService.setRacingcars(userInput.carNames());
        for (int i = 0; i < userInput.repeatNum(); i++) {
            RacingcarResults results = racingcarService.racing();
            racingcarView.printOutput(results);
        }

        racingcarView.printResult(racingcarService.findWinner());
    }
}
