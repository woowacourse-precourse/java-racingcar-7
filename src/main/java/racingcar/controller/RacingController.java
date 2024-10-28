package racingcar.controller;

import java.util.List;
import racingcar.common.Game;
import racingcar.service.RacingGameService;
import racingcar.util.RandomUtil;

public class RacingController {

    private final RacingGameService racingGameService;

    public RacingController() {
        this.racingGameService = new RacingGameService(new RandomUtil());
    }

    public List<String> start(Game game) {
        return racingGameService.play(game);
    }
}
