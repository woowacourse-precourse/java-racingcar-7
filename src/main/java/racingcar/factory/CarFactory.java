package racingcar.factory;

import java.util.List;
import java.util.function.Function;
import racingcar.common.constant.CarsType;
import racingcar.model.Car;
import racingcar.model.CarNameMap;
import racingcar.model.Cars;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public interface CarFactory{
  Function<List<Car>, Cars> getDefaultCollection ();
  Function<List<Car>, Cars> getCollection (CarsType carsType);
  public List<Car> createList(String[] carNames);

  public void validateNames(String[] carNames);
  public String[] splitCarNames(String rawCarNames);
  public List<String> createCarNames(String rawCarNames);

  public List<Car> getListFromRawCarNames(String rawCarNames);

  Car createCar(String carName);
  Cars createCars(String rawCarNames, CarsType carsType);
  Cars createDefaultCars(String rawCarNames);
}
