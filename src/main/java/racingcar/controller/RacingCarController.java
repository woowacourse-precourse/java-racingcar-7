package racingcar.controller;

import java.util.List;
import racingcar.model.service.RacingCarService;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarController {
    private final RacingCarService racingCarService;
    private final Input input;
    private final Output output;


    public RacingCarController(RacingCarService racingCarService, Input input, Output output) {
        this.racingCarService = racingCarService;
        this.input = new Input();
        this.output = new Output();
    }

    public void startGame() {
        List<String> carNames = input.getCarName();
        int tryCount = input.getRound();
        racingCarService.startGame();
    }

}
