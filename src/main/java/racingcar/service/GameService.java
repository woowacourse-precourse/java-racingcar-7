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
    return game.playRound()
        .orElseGet(Collections::emptyList);
  }

  public List<String> getWinners() {
    return game.getWinners();
  }
}
