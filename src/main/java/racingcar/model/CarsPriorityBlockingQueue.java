package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public class CarsPriorityBlockingQueue implements Cars{
  private final PriorityBlockingQueue<Car> cars;

  public CarsPriorityBlockingQueue(List<Car> cars){
    this.cars = new PriorityBlockingQueue<>(cars);
  }

  @Override
  public List<Car> findCarsByPosition(int position) {
    List<Car> foundCars = new ArrayList<>();
    List<Car> temporary = new ArrayList<>();
    while (!cars.isEmpty()){
      Car car = cars.poll();
      temporary.add(car);
      if (car.getPosition() < position){
        break;
      }
      if (car.getPosition() == position){
        foundCars.add(car);
      }
    }
    cars.addAll(temporary);
    return foundCars;
  }

  @Override
  public int findMaxPosition() {
    return cars.peek().getPosition();
  }

  @Override
  public List<Car> getWinners() {
    return findCarsByPosition(findMaxPosition());
  }
}
