package racingcar.service.car;

import racingcar.factory.CarFactory;
import racingcar.model.Cars;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 27.
 */
public class CarService {
  private final CarFactory carFactory;

  public CarService (CarFactory carFactory){
    this.carFactory = carFactory;
  }

  public Cars createParticipants(String rawCarNames) {
    Cars cars = carFactory.createDefaultCars(rawCarNames);
    return cars;
  }
}
