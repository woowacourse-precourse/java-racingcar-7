package racingcar.domain;

import java.util.List;
import java.util.Optional;

public class Game {

  private final Cars cars;
  private final GameCount gameCount;

  public Game(String carNames, String gameCountInput) {
    this.cars = new Cars(carNames);
    this.gameCount = new GameCount(gameCountInput);
  }

  public Optional<List<String>> playRound() {
    if (!canPlay()) {
      return Optional.empty();
    }
    cars.moveCars();
    gameCount.decrement();
    return Optional.of(getCurrentStatuses());
  }

  public List<String> getCurrentStatuses() {
    return cars.getAllCarStatuses();
  }

  public boolean canPlay() {
    return gameCount.canPlay();
  }

  public List<String> getWinners() {
    return cars.findWinners();
  }
}
