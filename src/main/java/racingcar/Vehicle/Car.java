package racingcar.Vehicle;

public class Car implements Vehicle {


  private String name;
  private int move;

  public Car(String name, int move) {
    this.name = name;
    this.move = move;
  }

  @Override
  public void updateMove() {
    this.move += 1;
  }


  @Override
  public void printStatus() {
    System.out.printf("%s : %s\n" , this.name , "-".repeat(this.move));
  }

  public int getMove()
  {
    return this.move;
  }

  public String getName()
  {
    return this.name;
  }

}
