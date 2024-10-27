package racingcar.domain;

public class Position {

  private int value;

  public Position() {
    this.value = 0;
  }

  public void increase() {
    this.value++;
  }

  public int getValue() {
    return this.value;
  }

  public boolean isEqualTo(int target) {
    return this.value == target;
  }
}
