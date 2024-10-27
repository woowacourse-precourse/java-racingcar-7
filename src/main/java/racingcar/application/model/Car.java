package racingcar.application.model;

public class Car {

  private final String name;
  private int forward;

  public Car(String name) {
    this.name = name;
    this.forward = 0;
  }

  public void move() {
    this.forward++;
  }

  public String getName() {
    return name;
  }

  public int getForward() {
    return forward;
  }
}
