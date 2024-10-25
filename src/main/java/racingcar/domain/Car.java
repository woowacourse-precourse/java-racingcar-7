package racingcar.domain;

import java.util.Objects;

public class Car {
  private final String name;

  public Car(String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Error: 자동차 이름은 비어있을 수 없습니다.");
    }
    if (name.length() > 5) {
      throw new IllegalArgumentException("Error: 자동차 이름은 5자 이하로 입력해야 합니다.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return Objects.equals(name, car.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name;
  }
}
