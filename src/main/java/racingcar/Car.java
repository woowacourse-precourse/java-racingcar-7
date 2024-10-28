package racingcar;

public class Car implements Comparable<Car>{
  private String name;
  private int moveCount;

  public Car(String name, int moveCount) {
    this.name = name;
    this.moveCount = moveCount;
  }

  public String getName() {
    return name;
  }

  public int getMoveCount() {
    return moveCount;
  }

  public void setMoveCountPlus() {
    this.moveCount ++;
  }
  @Override
  public int compareTo(Car car){
    return car.getMoveCount()-this.moveCount;
  }


}
