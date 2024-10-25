package racingcar.domain;


public class Game {
  private final Cars cars;
  private final RandomMoveCondition randomMoveCondition;

  public Game(Cars cars, RandomMoveCondition randomMoveCondition) {
    this.cars = cars;
    this.randomMoveCondition = randomMoveCondition;
  }

  public void playRound() {
    for (int i = 0; i < cars.size(); i++) {
      if (randomMoveCondition.isMovable()) {
        cars.move(i);
      }
    }
  }
}
