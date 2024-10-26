package racingcar.service;

import java.util.Collections;
import java.util.List;
import racingcar.domain.Game;

public class GameService {
  private Game game;


  public void createGame(String carNames, String gameCountInput) {
    this.game = new Game(carNames, gameCountInput);
  }

  public List<String> playRound() {
    if (game.canPlay()) {
      game.playRound();
      return game.getCurrentStatuses();
    }
    return Collections.emptyList();
  }

  public boolean isGameOver() {
    return !game.canPlay();
  }

  public List<String> getWinners() {
    return game.getWinners();
  }
}
