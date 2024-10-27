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
  List<Car> createList(List<String> carNames);

  void validateNames(List<String> carNames);
  List<String> splitCarNames(String rawCarNames);

  List<Car> getListFromRawCarNames(String rawCarNames);

  Car createCar(String carName);
  Cars createCars(String rawCarNames, CarsType carsType);
  Cars createDefaultCars(String rawCarNames);
}
