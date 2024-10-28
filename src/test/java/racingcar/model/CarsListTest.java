package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 28.
 */
class CarsListTest {

  private CarsList carsList;
  private Car car1, car2, car3;

  @BeforeEach
  void setUp() {
    car1 = Car.from("Car1");
    car2 = Car.from("Car2");
    car3 = Car.from("Car3");
    carsList = CarsList.from(Arrays.asList(car1, car2, car3));
  }

  @DisplayName("[Success]findCarsByPosition : 특정 위치에 있는 자동차(들) 반환")
  @Test
  void findCarsByPosition_shouldReturnCorrectCars() {
    car1.move(); // position 1
    car2.move(); // position 1
    car3.move();
    car3.move(); // position 2

    List<Car> carsAtPosition1 = carsList.findCarsByPosition(1);
    assertEquals(2, carsAtPosition1.size());
    assertTrue(carsAtPosition1.contains(car1));
    assertTrue(carsAtPosition1.contains(car2));

    List<Car> carsAtPosition2 = carsList.findCarsByPosition(2);
    assertEquals(1, carsAtPosition2.size());
    assertTrue(carsAtPosition2.contains(car3));
  }

  @DisplayName("[Success]findMaxPosition : 최고 위치 반환")
  @Test
  void findMaxPosition_shouldReturnCorrectMaximum() {
    car1.move(); // position 1
    car2.move();
    car2.move(); // position 2
    car3.move();
    car3.move();
    car3.move(); // position 3

    assertEquals(3, carsList.findMaxPosition());
  }

  @DisplayName("[Success]getWinners : 우승자(들) 반환")
  @Test
  void getWinnersShouldReturnCorrectWinners() {
    car1.move(); // position 1
    car2.move();
    car2.move(); // position 2
    car3.move();
    car3.move(); // position 2

    List<Car> winners = carsList.getWinners();
    assertEquals(2, winners.size());
    assertTrue(winners.contains(car2));
    assertTrue(winners.contains(car3));
  }

  @DisplayName("[Success]getList : 모든 자동차 리스트 반환")
  @Test
  void getListShouldReturnAllCars() {
    List<Car> allCars = carsList.getList();
    assertEquals(3, allCars.size());
    assertTrue(allCars.contains(car1));
    assertTrue(allCars.contains(car2));
    assertTrue(allCars.contains(car3));
  }

  @DisplayName("[Success]moveOrStayAll : 이동한 자동차 반환")
  @Test
  void moveOrStayAllShouldReturnMovedCars() {
    RacingRoundResult result = carsList.moveOrStayAll();
    List<Car> movedCars = result.movedCars();

    // 이동한 자동차의 수가 0에서 3 사이여야 함
    assertTrue(movedCars.size() >= 0 && movedCars.size() <= 3);

    // 이동한 자동차들의 위치가 1이어야 함
    for (Car car : movedCars) {
      assertEquals(1, car.getPosition());
    }

    // 이동하지 않은 자동차들의 위치는 0이어야 함
    for (Car car : carsList.getList()) {
      if (!movedCars.contains(car)) {
        assertEquals(0, car.getPosition());
      }
    }
  }
}