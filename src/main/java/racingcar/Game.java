package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

  private List<Car> carList = new ArrayList<>();

  private int trial;


  public Game(){}

  public Game(List<Car> carList, int trial) {
    this.carList = carList;
    this.trial = trial;
  }

  public List<Car> getCarList() {
    return carList;
  }

  public void setCarList(List<Car> carList) {
    this.carList = carList;
  }

  public int getTrial() {
    return trial;
  }

  public void setTrial(int trial) {
    this.trial = trial;
  }

  public List<String> returnMax(){
    List<String> result = new ArrayList<>();
    int firstBig = 0;
    for (Car car : this.carList) {
      if (car.getStep() > firstBig) {
        firstBig = car.getStep();
      }
    }
    for (Car car : this.carList) {
      if (car.getStep() == firstBig) {
        result.add(car.getCarName());
      }
    }
    return result;
  }
}

