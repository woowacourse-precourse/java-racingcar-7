package racingcar.model;

public class Car {

  private static final int MOVE_CONDITION = 4;
  private final String carName;
  private int moveCount = 0;

  public Car(String carName) {
    this.carName = carName;
  }

  public String getCarName() {
    return carName;
  }

  public int getMoveCount() {
    return moveCount;
  }

  private boolean isMovable(int random) {
    return random >= MOVE_CONDITION;
  }

  public void move(int randomNumber) {
    if (isMovable(randomNumber)) {
      moveCount++;
    }
  }
}
