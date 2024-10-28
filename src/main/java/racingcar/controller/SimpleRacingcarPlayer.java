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
    public RacingcarResults startRace() {
        UserInput userInput = racingcarView.getInput();
        // TODO. 메서드 구현
        return null;
    }
}
