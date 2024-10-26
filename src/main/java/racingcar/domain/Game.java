package racingcar.domain;

import java.util.List;

public class Game {

  private final Cars cars;
  private final GameCount gameCount;

  public Game(String carNames, String gameCountInput) {
    this.cars = new Cars(carNames);
    this.gameCount = new GameCount(gameCountInput);
  }

  public void playRound() {
    cars.moveCars();
    gameCount.decrement();
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
