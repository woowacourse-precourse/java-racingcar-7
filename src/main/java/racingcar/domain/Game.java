package racingcar.domain;

import java.util.Set;

public class Game {
  private final Cars cars;
  private final RandomMoveCondition randomMoveCondition;

  public Game(Cars cars, RandomMoveCondition randomMoveCondition) {
    this.cars = cars;
    this.randomMoveCondition = randomMoveCondition;
  }

  public void playRound() {
    Set<String> carNames = cars.getCarNames();

    for (String name : carNames) {
      if (randomMoveCondition.isMovable()) {
        //cars.move(name);
      }
    }
  }
}
