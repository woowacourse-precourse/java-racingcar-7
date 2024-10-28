package racingcar.service.car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.container.DependencyInjectionContainer;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.CarsList;
import racingcar.service.racing.RacingService;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 28.
 */
class CarServiceTest {

  private CarService carService;

  @BeforeEach
  void setUp() {

    DependencyInjectionContainer container = new DependencyInjectionContainer();
    carService = container.get(CarService.class);
  }

  @DisplayName("[Success]createParticipants : Cars 객체 생성")
  @Test
  void createParticipants() {
    String rawCarNames = "car1,car2,car3";
    Cars cars = carService.createParticipants(rawCarNames);

    assertNotNull(cars);
    List<Car> carList = cars.getList();
    assertEquals("car1", carList.get(0).getName());
    assertEquals("car2", carList.get(1).getName());
    assertEquals("car3", carList.get(2).getName());
    for (Car car : carList){
      assertEquals(0, car.getPosition());
    }
  }
}