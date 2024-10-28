package racingcar.domain.game;

public class GameCount {

  private final Count count;

  public GameCount(String gameCountInput) {
    this.count = new Count(gameCountInput);
  }

  public void decrement() {
    this.count.decrement();
  }

  public boolean canPlay() {
    return this.count.canPlay();
  }
}
