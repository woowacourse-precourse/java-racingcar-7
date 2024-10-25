package racingcar.factory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import racingcar.common.constant.CarsType;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.strategy.CarStrategy;
import racingcar.strategy.CarsStrategy;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public class CarDefaultFactory implements CarFactory{
  private final CarStrategy carStrategy;
  private final CarsStrategy carsStrategy;

  public CarDefaultFactory(CarStrategy carStrategy, CarsStrategy carsStrategy) {
    this.carStrategy = carStrategy;
    this.carsStrategy = carsStrategy;
  }

  @Override
  public Car createCar(String carName) {
    return Car.from(carName);
  }

  private Function<List<Car>, Cars> getDefaultCollection () {
    return carsStrategy.getDefaultCollection();
  }

  private Function<List<Car>, Cars> getCollection (CarsType carsType) {
    return carsStrategy.getCollection(carsType);
  }

  private List<Car> createList(String[] carNames) {
    return Arrays.stream(carNames)
        .map(this::createCar)
        .collect(Collectors.toList());
  }

  @Override
  public Cars createCars(String rawCarNames) {
    String[] carNames = carStrategy.splitNames(rawCarNames);
    carStrategy.validateNames(carNames);
    return getDefaultCollection()
        .apply(createList(carNames));
  }
}
