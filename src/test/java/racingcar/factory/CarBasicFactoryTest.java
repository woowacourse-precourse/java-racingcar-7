package racingcar.factory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.container.DependencyInjectionContainer;
import racingcar.model.Car;
import racingcar.model.Cars;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 28.
 */
class CarBasicFactoryTest {
  private CarFactory carFactory;

  @BeforeEach
  void setUp(){
    DependencyInjectionContainer container = new DependencyInjectionContainer();
    carFactory = container.get(CarFactory.class);
  }


  @DisplayName("[Success]createCar : Car 객체 생성")
  @Test
  void createCar_shouldReturnCar() {
    Car car = carFactory.createCar("TestCar");
    assertNotNull(car);
    assertEquals("TestCar", car.getName());
  }

  @DisplayName("[Success]createList : Car 객체 리스트 생성")
  @Test
  void createList_shouldReturnListOfCars() {
    List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
    List<Car> cars = carFactory.createList(carNames);

    assertEquals(3, cars.size());
    assertEquals("Car1", cars.get(0).getName());
    assertEquals("Car2", cars.get(1).getName());
    assertEquals("Car3", cars.get(2).getName());
  }
}