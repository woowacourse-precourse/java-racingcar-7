package racingcar.controller;

import racingcar.dto.RacingCarRequest;
import racingcar.dto.RacingCarResponse;
import racingcar.model.service.RacingCarService;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class GameController {
    private final RacingCarService racingCarService;

    public GameController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run() {
        List<String> carNames = Input.carName();
        int moveCount = Input.moveCount();
        RacingCarRequest request = new RacingCarRequest(carNames, moveCount);

        RacingCarResponse response = racingCarService.startGame(request);

        Output.result(response.cars(), moveCount);
        Output.winner(response.winCars());
    }
}
