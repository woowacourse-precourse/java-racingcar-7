package racingcar.domain;


import java.util.List;

public class Game {
  private final Cars cars;
  private final RandomMoveCondition randomMoveCondition;

  public Game(Cars cars, RandomMoveCondition randomMoveCondition) {
    this.cars = cars;
    this.randomMoveCondition = randomMoveCondition;
  }

  public List<String> playRound() {
    cars.moveCars(randomMoveCondition);
    return cars.getAllCarStatuses();
  }

  public List<String> findWinners() {
    return cars.findWinners();
  }
}
