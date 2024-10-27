package racingcar.controller;

import racingcar.model.domain.GameResult;
import racingcar.model.service.GameService;

public class GameController {

    private GameController() {
    }

    public static GameResult playRacingGame(int roundCount, String carNames) {
      return GameService.play(roundCount,carNames);
    }
}