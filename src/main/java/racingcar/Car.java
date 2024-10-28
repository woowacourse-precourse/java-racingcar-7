package racingcar;

public class Car {
  private static final int MOVE_THRESHOLD = 4;
  private final String name;
  private int distance = 0;

  public Car(String name) {
    validateName(name);
    this.name = name;
  }

  public void move(int randomNumber) {
    if (randomNumber >= MOVE_THRESHOLD) {
      distance++;
    }
  }

  public String getName() {
    return name;
  }

  public String getPosition() {
    return "-".repeat(distance);
  }

  private void validateName(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
    }
  }
}
