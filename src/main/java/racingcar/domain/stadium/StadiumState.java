package racingcar.domain.stadium;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;

public class StadiumState  {
  final public List<Car> cars;


  public StadiumState(StadiumState stadiumState){
    this.cars = stadiumState.cars;

  }
  public StadiumState(){
    this.cars =  new ArrayList<>();

  }

  public void addCar(Car car) {

    this.cars.add(car);
  }

}
