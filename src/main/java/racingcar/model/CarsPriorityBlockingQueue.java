package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public class CarsPriorityBlockingQueue implements Cars{
  private final PriorityBlockingQueue<Car> cars;

  private CarsPriorityBlockingQueue(List<Car> cars){
    this.cars = new PriorityBlockingQueue<>(cars);
  }

  public static CarsPriorityBlockingQueue from (List<Car> cars) {
    return new CarsPriorityBlockingQueue(cars);
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

  @Override
  public List<Car> getList() {
    return cars.stream()
        .toList();
  }

  @Override
  public RacingRoundResult moveOrStayAll() {
    List<Car> movedCars = cars.stream()
        .filter(car ->{
          HasCarMoved result = car.moveOrStay();
          return result.moved();
        })
        .collect(Collectors.toList());
    return RacingRoundResult.from(movedCars);
  }
}
