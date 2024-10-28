package racingcar.factory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import racingcar.common.constant.CarsType;
import racingcar.model.Car;
import racingcar.model.CarNameMap;
import racingcar.model.Cars;
import racingcar.strategy.CarStrategy;
import racingcar.strategy.CarsStrategy;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public class CarBasicFactory implements CarFactory{
  private final CarStrategy carStrategy;
  private final CarsStrategy carsStrategy;

  public CarBasicFactory(CarStrategy carStrategy, CarsStrategy carsStrategy){
    this.carStrategy = carStrategy;
    this.carsStrategy = carsStrategy;
  }

  @Override
  public Car createCar(String carName){
    return Car.from(carName);
  }

  @Override
  public Function<List<Car>, Cars> getDefaultCollection(){
    return carsStrategy.getDefaultCollection();
  }

  @Override
  public Function<List<Car>, Cars> getCollection (CarsType carsType){
    return carsStrategy.getCollection(carsType);
  }

  @Override
  public List<Car> createList(List<String> carNames){
    return carNames.stream()
        .map(this::createCar)
        .collect(Collectors.toList());
  }

  @Override
  public void validateNames(List<String> carNames){
    carStrategy.validateNames(carNames);
  }

  @Override
  public List<String> splitCarNames(String rawCarNames){
    return carStrategy.splitNames(rawCarNames);
  }

  @Override
  public List<Car> getListFromRawCarNames(String rawCarNames){
    List<String> carNames = splitCarNames(rawCarNames);
    validateNames(carNames);
    return createList(carNames);
  }

  @Override
  public Cars createCars(String rawCarNames, CarsType carsType){
    return getCollection(carsType)
        .apply(getListFromRawCarNames(rawCarNames));
  }

  @Override
  public Cars createDefaultCars(String rawCarNames){
    return getDefaultCollection()
        .apply(getListFromRawCarNames(rawCarNames));
  }
}
