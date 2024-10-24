package racingcar;

public class Car {

  private String carName;

  private int step;

  public Car(String carName , int step)
  {
    this.carName = carName;
    this.step = step;
  }

  public void printStatus(){
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < this.getStep(); i++)
    {
      result.append("-");
    }
    System.out.printf("%s : %s%n", carName, result);
  }


  public String getCarName() {
    return carName;
  }

  public int getStep() {
    return step;
  }

  public void setCarName(String carName) {
    this.carName = carName;
  }

  public void setStep(int step) {
    this.step = step;
  }
}
