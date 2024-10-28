package racingcar;

public class Car {
  private final String name;
  private int position = 0;

  public Car(String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if (name == null || name.trim().isEmpty() || name.length() > 5) {
      throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }
  }

  public void move(int randomValue) {
    // 전진 조건을 4 이상일 때로 수정
    if (randomValue >= 4) {
      position++;  // 한 칸만 전진
    }
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public String getPositionAsString() {
    return "-".repeat(position);
  }
}
