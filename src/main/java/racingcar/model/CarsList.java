package racingcar.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public class CarsList implements Cars{
  private final List<Car> cars;

  public CarsList(List<Car> cars) {
    this.cars = new ArrayList<>(cars);
  }

  public static CarsList from (List<Car> cars) {
    return new CarsList(cars);
  }

  @Override
  public List<Car> findCarsByPosition(int position){
    return cars.stream()
        .filter(car -> car.getPosition() == position)
        .toList();
  }

  @Override
  public int findMaxPosition(){
    return cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(0);
  }

  @Override
  public List<Car> getWinners () {
    return findCarsByPosition(findMaxPosition());
  }
}
