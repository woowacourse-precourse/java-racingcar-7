package racingcar.domain;

import racingcar.error.ErrorMessages;

public class Car {

  private static final int MAX_NAME_LENGTH = 5;
  private final String name;
  private int position;

  public Car(String name) {
    validateName(name);
    this.position = 0;
    this.name = name;
  }

  private void validateName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException(ErrorMessages.CAR_NAME_EMPTY);
    }
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException(ErrorMessages.CAR_NAME_TOO_LONG);
    }
  }

  public void move() {
    this.position++;
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }
}
