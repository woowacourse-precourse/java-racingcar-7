package racingcar.controller;

import racingcar.dto.RacingcarResults;
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
        // TODO. 메서드 구현
        return null;
    }
}
