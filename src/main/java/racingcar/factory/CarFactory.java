package racingcar.factory;

import racingcar.model.Car;
import racingcar.model.Cars;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public interface CarFactory{
  Car createCar(String carName);
  Cars createCars(String rawCarNames);
}
