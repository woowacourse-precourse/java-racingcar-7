package racingcar.service;

import java.util.List;
import racingcar.domain.game.Game;
import racingcar.view.CarStatusDTO;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

public class GameService {

  private Game game;

  public void initializeGame(String carNamesInput, String gameCountInput) {
    MoveStrategy moveStrategy = new RandomMoveStrategy();
    this.game = new Game(carNamesInput, gameCountInput, moveStrategy);
  }

  public boolean canPlay() {
    return this.game.canPlay();
  }

  public void playRound() {
    this.game.playRound();
  }

  public List<CarStatusDTO> getCurrentStatuses() {
    return this.game.getCurrentStatuses();
  }

  public List<String> getWinners() {
    return this.game.getWinners();
  }
}
