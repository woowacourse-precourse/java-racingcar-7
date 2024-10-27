package racingcar.domain;

public class Car {

  private final String name;
  private final Position position;

  public Car(String name) {
    this.name = name;
    this.position = new Position();
  }

  public void tryToMove(int randomValue) {
    if (randomValue >= 4) {
      position.move();
    }
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position.getPosition();
  }
}
