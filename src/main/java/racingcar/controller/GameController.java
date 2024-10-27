package racingcar.controller;

import racingcar.model.domain.GameResult;
import racingcar.model.service.GameService;

public class GameController {

    private GameController() {
    }

    public static GameResult playRacingGame(int roundCnt, String carNames) {
      return GameService.play(roundCnt,carNames);
    }
}