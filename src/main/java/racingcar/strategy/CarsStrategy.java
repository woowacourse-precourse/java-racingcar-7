package racingcar.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import racingcar.common.constant.CarsType;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.CarsList;
import racingcar.model.CarsPriorityBlockingQueue;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 26.
 */
public class CarsStrategy{
  private final Map<CarsType, Function<List<Car>, Cars>> carStrategy;

  public CarsStrategy(){
    this.carStrategy = new HashMap<>();
    this.carStrategy.put(CarsType.LIST, CarsList::from);
    this.carStrategy.put(CarsType.PRIORITY_BLOCKING_QUEUE, CarsPriorityBlockingQueue::from);
  }
  
  public Function<List<Car>, Cars> getCollection(CarsType carsType){
    return carStrategy.get(carsType);
  }

  public Function<List<Car>, Cars> getDefaultCollection(){
    return carStrategy.get(CarsType.LIST);
  }
}
