package racingcar.container;

import java.util.HashMap;
import java.util.Map;
import racingcar.controller.RacingCarController;
import racingcar.factory.CarBasicFactory;
import racingcar.factory.CarFactory;
import racingcar.service.car.CarService;
import racingcar.service.racing.RacingService;
import racingcar.strategy.CarBasicStrategy;
import racingcar.strategy.CarStrategy;
import racingcar.strategy.CarsStrategy;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 27.
 */
public class DependencyInjectionContainer {
  private final Map<Class<?>, Object> container = new HashMap<>();

  private void createRacingCarController() {
    CarStrategy carStrategy = new CarBasicStrategy();
    CarsStrategy carsStrategy = new CarsStrategy();
    CarFactory carFactory = new CarBasicFactory(carStrategy, carsStrategy);
    RacingService racingService = new RacingService();
    CarService carService = new CarService(carFactory);
    RacingCarController racingCarController = new RacingCarController(racingService, carService);
    container.put(RacingCarController.class, racingCarController);
  }

  public DependencyInjectionContainer(){
    createRacingCarController();
  }

  public <T> T get(Class<T> type){
    Object instance = container.get(type);
    return type.cast(instance);
  }
}
